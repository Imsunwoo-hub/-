package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_사회망서비스 {
	
	static ArrayList<ArrayList<Integer>> list;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][2];
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) list.add(new ArrayList<Integer>());
		for(int i=0; i<=N; i++) for(int j=0; j<2; j++) dp[i][j] = -1;
		
		for(int i=0; i<N-1; i++) {
			String[] s= br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		System.out.println(Math.min(dfs(1,0,0), dfs(1,0,1)));
		
		
	}
	
	public static int dfs(int n, int b, int s) {
		if(dp[n][s]!=-1) return dp[n][s];
		
		int result = 0;
		if(s==0) {
			for(int l:list.get(n)) {
				if(l==b) continue;
				result += dfs(l,n,1); 
			}
			return dp[n][s] = result;
		}
		
		else {
			for(int l:list.get(n)) {
				if(l==b) continue;
				result  += Math.min(dfs(l,n,0), dfs(l,n,1));
			}
			return dp[n][s] = result + 1;
		}
		
	}
	
}
