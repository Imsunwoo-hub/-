package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1726_로봇 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][][] v = new int[N][M][4];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		
		int[] start = new int[3];
		int[] end = new int[3];
		
		s = br.readLine().split(" ");
		for(int i=0; i<3; i++) start[i] = Integer.parseInt(s[i])-1;
		
		s = br.readLine().split(" ");
		for(int i=0; i<3; i++) end[i] = Integer.parseInt(s[i])-1;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[3], o2[3]);
			}
		});
		v[start[0]][start[1]][start[2]] = 1;
		q.offer(new int[] {start[0], start[1], start[2], 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==end[0] && curr[1]==end[1] && curr[2]==end[2]) {
				System.out.println(curr[3]);
				return;
			}
			
			if(curr[2]==0) {
				if(v[curr[0]][curr[1]][2]==0) {
					v[curr[0]][curr[1]][2]=1;
					q.offer(new int[] {curr[0],curr[1],2,curr[3]+1});
				}
				if(v[curr[0]][curr[1]][3]==0) {
					v[curr[0]][curr[1]][3]=1;
					q.offer(new int[] {curr[0],curr[1],3,curr[3]+1});
				}
			}
			else if(curr[2]==1) {
				if(v[curr[0]][curr[1]][2]==0) {
					v[curr[0]][curr[1]][2]=1;
					q.offer(new int[] {curr[0],curr[1],2,curr[3]+1});
				}
				if(v[curr[0]][curr[1]][3]==0) {
					v[curr[0]][curr[1]][3]=1;
					q.offer(new int[] {curr[0],curr[1],3,curr[3]+1});
				}
			}
			else if(curr[2]==2) {
				if(v[curr[0]][curr[1]][0]==0) {
					v[curr[0]][curr[1]][0]=1;
					q.offer(new int[] {curr[0],curr[1],0,curr[3]+1});
				}
				if(v[curr[0]][curr[1]][1]==0) {
					v[curr[0]][curr[1]][1]=1;
					q.offer(new int[] {curr[0],curr[1],1,curr[3]+1});
				}
			}
			else {
				if(v[curr[0]][curr[1]][0]==0) {
					v[curr[0]][curr[1]][0]=1;
					q.offer(new int[] {curr[0],curr[1],0,curr[3]+1});
				}
				if(v[curr[0]][curr[1]][1]==0) {
					v[curr[0]][curr[1]][1]=1;
					q.offer(new int[] {curr[0],curr[1],1,curr[3]+1});
				}
			}
			
			for(int i=1; i<=3; i++) {
				int ni = curr[0]+di[curr[2]]*i;
				int nj = curr[1]+dj[curr[2]]*i;
				if(ni>=0 && nj>=0 && ni<N && nj<M ) {
					if(map[ni][nj]==1) break;
					if(map[ni][nj] == 0 && v[ni][nj][curr[2]]==0) {
						v[ni][nj][curr[2]]=1;
						q.offer(new int[] {ni,nj,curr[2],curr[3]+1});
					}
				}
			}
		}
		
	}

}
