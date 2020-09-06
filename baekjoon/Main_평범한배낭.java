package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_평범한배낭 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[][] ia = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			s = br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(s[0]);
			ia[i][1] = Integer.parseInt(s[1]);
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(j - ia[i][0] < 0) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], ia[i][1] + dp[i-1][j - ia[i][0]]);
			}
		}
		
		//for(int[] i:dp) System.out.println(Arrays.toString(i));
		
		System.out.println(dp[N][K]);

	}

}
