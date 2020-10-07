package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_17836_공주님을구해라 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int T = Integer.parseInt(s[2]);
		
		int[][] map = new int[N][M];
		int[][][] v = new int[N][M][2];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[3], o2[3]);
			}
		});
		
		q.offer(new int[] {0,0,0,0});
		v[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[3]>T) continue;
			if(curr[0]==N-1 && curr[1]==M-1) {
				System.out.println(curr[3]);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<M) {
					if(curr[2]==0) {
						if(map[ni][nj]==0 && v[ni][nj][curr[2]]==0) {
							v[ni][nj][curr[2]]=1;
							q.offer(new int[] {ni,nj,curr[2],curr[3]+1});
						}
						else if(map[ni][nj]==2 && v[ni][nj][curr[2]]==0) {
							v[ni][nj][curr[2]]=1;
							q.offer(new int[] {ni,nj,1,curr[3]+1});
						}
					}
					else {
						if(v[ni][nj][curr[2]]==0) {
							v[ni][nj][curr[2]]=1;
							q.offer(new int[] {ni,nj,curr[2],curr[3]+1});
						}
					}
				}
			}
		}
		
		System.out.println("Fail");
	}

}
