package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_배달 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] map = new char[N][M];
		int[][][][][] v = new int[N][M][4][2][2];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		int bol = 0;
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j]=='S') {
					q.offer(new int[] {i,j,0,-1,0,0});
				}
				if(map[i][j]=='C') {
					if(bol==0) bol = 1;
					else map[i][j] = 'D';
				}
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		int result = -1;
		
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			
				if(curr[4]==1 && curr[5]==1) {
					result = curr[2];
					break;
				}
				
				for(int d=0; d<4; d++) {
					if(d==curr[3]) continue;
					int ni = curr[0] + di[d];
					int nj = curr[1] + dj[d];
					int nc = curr[4];
					int nd = curr[5];
					if(ni>=0 && nj>=0 && ni<N && nj<M ) {
						if(map[ni][nj] !='#' && v[ni][nj][d][nc][nd]==0) {
							if(map[ni][nj]=='C') nc = 1;
							if(map[ni][nj]=='D') nd = 1;
							
							q.offer(new int[] {ni,nj,curr[2]+1,d,nc,nd});
							 v[ni][nj][d][nc][nd]=1;
						}
					}
				}
			
		}
		
		
		
		System.out.println(result);
		
		

	}

}
