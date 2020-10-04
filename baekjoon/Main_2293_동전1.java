package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2293_동전1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] ia = new int[N];
		int[] dp = new int[M+1];
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		for(int i=0; i<N; i++ ) {
			for(int j=ia[i]; j<=M; j++) {
				if(j-ia[i] >= 0) dp[j] += dp[j-ia[i]];
				//System.out.println(Arrays.toString(dp));
			}
		}
		System.out.println(dp[M]);

	}

}
