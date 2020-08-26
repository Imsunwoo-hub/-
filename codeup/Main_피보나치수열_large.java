package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_피보나치수열_large {
	
	static int[] dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		System.out.println(f(N));

	}
	
	public static int f( int n) {
		if(dp[n]>0) return dp[n]%10009;
		if(n<=1) return n;
		else {
			return dp[n] = ((f(n-1)%10009) + (f(n-2)%10009)) %10009; 
		}
		
	}

}
