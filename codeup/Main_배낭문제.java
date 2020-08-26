package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_배낭문제 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int W = Integer.parseInt(s[1]);
		
		int[] wa = new int[N+1];
		int[] va = new int[N+1];
		
		
		for(int i=1; i<=N; i++) {
			 s = br.readLine().split(" ");
			 wa[i] = Integer.parseInt(s[0]);
			 va[i] = Integer.parseInt(s[1]);
		}
		
		int[][] dp = new int[N+1][W+1];
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<=W; j++) {
				if(j-wa[i]<0) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wa[i]]+va[i]);
			}
		}
		
		System.out.println(dp[N][W]);
		
	}

}
