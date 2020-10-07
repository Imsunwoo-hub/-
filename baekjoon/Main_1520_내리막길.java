package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1520_내리막길 {
	
	static int N,M;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] dp, map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		dp = new int[N][M];
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				dp[i][j] = -1;
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	public static int dfs(int i, int j) {
		if(i==N-1 && j==M-1) return dp[i][j] = 1;
		if(dp[i][j]!=-1) return dp[i][j];
		dp[i][j] = 0;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj >=0 && ni<N && nj<M && map[i][j] > map[ni][nj]) {
				dp[i][j] += dfs(ni,nj);
			}
		}
		
		return dp[i][j];
	}

}
