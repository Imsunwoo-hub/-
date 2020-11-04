package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_유기농배추 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int M = 0;
	static int N = 0;
	static int K = 0;
	static int cnt = 0;
	static int[][] ia = new int[51][51];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			
			setting(ia,M,N);
			
			for(int i=0; i<K; i++) {
				s = br.readLine().split(" ");
				ia[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
			}
			cnt = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(ia[i][j]==1) {
						cnt++;
						ia[i][j] = 0;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

	public static void dfs(int i, int j) {
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<M && nj<N && ia[ni][nj]==1) {
				ia[ni][nj] = 0;
				dfs(ni,nj);
			}
		}
	}
	
	public static void setting(int[][] ia, int M, int N) {
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				ia[i][j] = 0;
			}
		}
	}

}
