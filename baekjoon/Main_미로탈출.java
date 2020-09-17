package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_미로탈출 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][][] v = new int[N][M][2];
		
		int[] start = new int[2];
		s = br.readLine().split(" ");
		start[0] = Integer.parseInt(s[0])-1;
		start[1] = Integer.parseInt(s[1])-1;
		
		int[] end = new int[2];
		s = br.readLine().split(" ");
		end[0] = Integer.parseInt(s[0])-1;
		end[1] = Integer.parseInt(s[1])-1;
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int result = -1;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[3], o2[3]);
			}
		});
		
		q.offer(new int[] {start[0],start[1], 0, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]][curr[2]]==0) {
				v[curr[0]][curr[1]][curr[2]] = 1;
				
				if(curr[0]==end[0] && curr[1]==end[1]) {
					result = curr[3];
					break;
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M) {
						if(map[ni][nj]==1) {
							if(curr[2]==0) {
								if(v[ni][nj][curr[2]+1]==0) {
									q.offer(new int[] {ni,nj,curr[2]+1,curr[3]+1});
								}
							}
						}
						else {
							if(v[ni][nj][curr[2]]==0) {
								q.offer(new int[] {ni,nj,curr[2],curr[3]+1});
							}
						}
					}
				}
			}
		}
		
		
		System.out.println(result);
	}
}
