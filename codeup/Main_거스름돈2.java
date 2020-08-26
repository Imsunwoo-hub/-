package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_거스름돈2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] ia = new int[M];
		int[] dp = new int[N+1];
		for(int i=0; i<M; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		dp[0] = 0;
		for(int i=1; i<=N; i++) {
			int temp = Integer.MAX_VALUE/2;
			for(int j=0; j<M; j++) {
				if(i-ia[j] < 0) continue;
				temp = Math.min(temp, dp[i-ia[j]]);
			}
			dp[i] = 1+temp;
		}
		System.out.println(dp[N]);
	}
}
