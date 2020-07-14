package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution_트리흑백색칠 {
	
	static int mod = 1000000007;
	static int N;
	static List<Integer>[] adj;
	static long[][] memo;

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/input_d5_4534.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N+1]; 
			for(int i=1; i<=N; i++) {
				adj[i] = new ArrayList<>();
			}
			memo = new long[2][N+1];
			for(int i =1; i<N; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				adj[a].add(b);
				adj[b].add(a);
			}
			long ans = (dfs(1,0,-1) + dfs(1,1,-1)) % mod;	
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static long dfs(int v, int color , int parent) {
		if(memo[color][v]!=0) {
			return memo[color][v];
		}
		long ret = 1;
		
		if(color == 0) {
			for(int i=0; i<adj[v].size(); i++) {
				if(adj[v].get(i) != parent) {
					ret *= dfs(adj[v].get(i), 1, v);
					ret %= mod;
				}
			}
		}
		else {
			for(int i=0; i<adj[v].size(); i++) {
				if(adj[v].get(i) != parent) {
					ret *= (dfs(adj[v].get(i), 1, v) + dfs(adj[v].get(i), 0, v));
					ret %= mod;
				}
			}
		}
		memo[color][v] = ret;
		return ret;
	}

}
