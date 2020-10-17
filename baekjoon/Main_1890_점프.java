package beakjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_1890_점프 {
	
	static int[][] map;
	static long[][] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new long[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				dp[i][j] = -1;
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		System.out.println(dfs(0,0));
		
	}
	
	public static long dfs(int i, int j) {
		if(dp[i][j]!=-1) return dp[i][j];
		if(i==N-1 && j==N-1) return dp[i][j] = 1;
		
		dp[i][j] = 0;
		
		if(i+map[i][j] < N) dp[i][j] += dfs(i+map[i][j],j);
		if(j+map[i][j] < N) dp[i][j] += dfs(i, j+map[i][j]);
		
		return dp[i][j];
	}

}
