package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1103_게임 {
	
	static int N,M;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static char[][] map;
	static int[][] dp, v;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" "); 
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		v = new int[N][M];
		dp = new int[N][M];
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0,0));
	}
	
	public static int dfs(int i, int j, int c) {
		if(i<0 || j<0 || i>=N || j>=M || map[i][j] == 'H') return 0;
		if(v[i][j]==1) { {
			System.out.println(-1);
			System.exit(0); }
		}
		
		if(dp[i][j] != -1) return dp[i][j];
		v[i][j] = 1;
		dp[i][j] = 0;
		for(int d=0; d<4; d++) {
			int ni = i+di[d]*(map[i][j]-'0');
			int nj = j+dj[d]*(map[i][j]-'0');
			dp[i][j] = Math.max(dp[i][j], dfs(ni,nj,c+1)+1);	
		}
		v[i][j] = 0;
		return dp[i][j];
	}

}
