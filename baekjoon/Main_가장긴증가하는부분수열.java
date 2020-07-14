package baekjoon;

import java.util.Scanner;

public class Main_가장긴증가하는부분수열{

	public static void main(String[] args) throws Exception {
		 
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] ia = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] = sc.nextInt();
		}
		
		int max = 1;
		dp[0] = 1;
		for(int i=1; i<N; i++) {
			int tmax = 0;
			int tmidx = -1;
			for(int j=i-1; j>=0; j--) {
				if(ia[j] < ia[i] && dp[j] > tmax) {
					tmax = dp[j];
					tmidx = j;
				}
			}
			if(tmidx == -1) dp[i] = 1;
			else {
				dp[i] = dp[tmidx]+1;
				if(dp[i] > max) max = dp[i];
			}
		}
		
		System.out.println(max);

	}

}