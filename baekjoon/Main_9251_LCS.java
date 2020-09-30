package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9251_LCS {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		int max = 0;
		
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(dp[i][j] > max) max = dp[i][j];
			}
		}
		
		System.out.println(max);

	}

}
