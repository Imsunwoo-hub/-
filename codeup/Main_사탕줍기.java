package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_사탕줍기 {
	
	static int N,M;
	static int[][] map, dp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		dp = new int[N][M];
		dfs(0,0);
		System.out.println(dp[0][0]);
	}
	
	public static int dfs(int i, int j) {
		if(i>=N || j>=M) return 0;
		if(dp[i][j]!=0) return dp[i][j];
		
		return dp[i][j] = Math.max(dfs(i+1,j) + map[i][j], dfs(i,j+1)+ map[i][j]);
	}
}
