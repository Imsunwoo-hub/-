package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_벽부수고이동하기3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j)-'0';
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2],o2[2]);
			}
		});
		int[][][] v = new int[N][M][K+1];
		int result = -1;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		int bol = 0;
		
		q.offer(new int[] {0,0,1,0});
		v[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			
			int roop = q.size();
			
			while(roop-- > 0) {
				
				int[] curr = q.poll();
			
				if(curr[0]==N-1 && curr[1]==M-1) {
					result = curr[2];
					System.out.println(result);
					return;
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M) {
						if(map[ni][nj]==1 && curr[3]<K  && v[ni][nj][curr[3]+1]==0 ){
							if(bol==0) {
								q.offer(new int[] {ni,nj,curr[2]+1, curr[3]+1});
								v[ni][nj][curr[3]+1] = 1;
							}
							else {
								q.offer(new int[] {curr[0], curr[1], curr[2]+1, curr[3]});
							}
						}
						if(map[ni][nj]==0 && v[ni][nj][curr[3]]==0) {
							q.offer(new int[] {ni,nj,curr[2]+1, curr[3]});
							v[ni][nj][curr[3]] = 1;
						}
					}
				}
			}
			bol = (bol+1)%2;
		}
		
		System.out.println(result);

	}

}
