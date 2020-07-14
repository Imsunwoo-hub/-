package baekjoon;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;

public class Main_보물섬 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] ca = new char[N][M];
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				ca[i][j] = t.charAt(j);
			}
		}
		int result = 0;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ca[i][j]=='L') {
					int[][] v= new int[N][M];
					PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							
							return Integer.compare(o1[2], o2[2]);
						}
					});
					q.offer(new int[] {i,j,0});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
	
						if(v[curr[0]][curr[1]]==0) {
							v[curr[0]][curr[1]] = 1;
							if(curr[2]>result) result = curr[2];
							for(int d=0; d<4; d++) {
								int ni = curr[0]+di[d];
								int nj = curr[1]+dj[d];
								if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0 && ca[ni][nj]=='L') {
									q.offer(new int[] {ni,nj,curr[2]+1});
								}
							}
						}
						
					}
				}
			}
		}
		System.out.println(result);
	}
}
