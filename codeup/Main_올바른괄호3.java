package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_올바른괄호3 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] += dp[i-j] * dp[j-1];
			}
		}
		
		System.out.println(dp[N]);

	}
	
}
