package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1학년 {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		
		String[] s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		
		long[][] dp = new long[N][21];
		
		for(int i=0; i<N; i++) for(int j=0; j< 21; j++) dp[i][j] = -1;
		
		System.out.println(dfs(1,ia[0],ia[ia.length-1],ia, dp));

	}
	
	public static long dfs(int i, int temp, int end, int[] ia, long[][] dp) {
		if(dp[i][temp]!=-1) return dp[i][temp];
		if(i==ia.length-1) {
			if(temp==end) return dp[i][temp] = 1;
			return 0;
		}
		long result = 0;
		if(temp+ia[i] <= 20) result += dfs(i+1, temp+ia[i], end, ia, dp);
		if(temp-ia[i] >= 0) result += dfs(i+1, temp-ia[i], end, ia, dp);
		
		return dp[i][temp] = result;
	}

}
