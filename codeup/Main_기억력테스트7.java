package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_기억력테스트7 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		String[] t = br.readLine().split(" ");
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(t[i]);
		}
		int[] dp = new int[N];
		dp[0] = ia[0];
		for(int i=1; i<N; i++) {
			dp[i] = dp[i-1]+ia[i];
		}
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0])-1;
			int end = Integer.parseInt(s[1])-1;
			if(start==0) System.out.println(dp[end]);
			else System.out.println(dp[end]-dp[start-1]);
		}

	}

}
