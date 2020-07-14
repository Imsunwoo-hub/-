package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_퇴사 {
	
	static int N;
	static int[][] ia;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ia = new int[N+2][2];
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N ; i++) {
			String[] t = br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(t[0]);
			ia[i][1] = Integer.parseInt(t[1]);
		}
		
		int result = 0;
		 for(int i=1; i<=N + 1; i++){
	            for(int j=1; j<i; j++){
	                
	                dp[i] = Math.max(dp[i], dp[j]);
	                if(j + ia[j][0] == i){
	                    dp[i] = Math.max(dp[i], dp[j] + ia[j][1]);
	                }
	            }

	            result = Math.max(result, dp[i]);
	        }

	    
		System.out.println(result);
	}
}
