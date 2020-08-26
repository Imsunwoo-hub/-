package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_앱 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] ma = new int[N+1];
		String[] t = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ma[i+1] =Integer.parseInt(t[i]); 
		}
		
		t = br.readLine().split(" ");
		int[] va = new int[N+1];
		int sum = 0;
		for(int i=0; i<N; i++) {
			va[i+1] =Integer.parseInt(t[i]);
			sum += va[i+1];
		}
		
		int[][] dp = new int[N+1][sum+1];
		int result = -1;
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=sum; j++) {
				if(j-va[i]<0) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], ma[i]+dp[i-1][j-va[i]]);
				if(dp[i][j]>=M) {
					result = j;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
