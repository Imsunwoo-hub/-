package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_축사배정 {
	
	static int N,M;
	static int[] v,b;
	static ArrayList<Integer>[] match;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		match = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) match[i] = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			s = br.readLine().split(" ");
			int end = Integer.parseInt(s[0]);
			for(int j=1; j<=end; j++) {
				match[i].add(Integer.parseInt(s[j]));
			}
		}
		
		b = new int[M+1];
		int cnt = 0;
		for(int i=1; i<=N; i++ ) {
			v = new int[N+1];
			if(dfs(i)) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean dfs(int i) {
		if(v[i]==1) return false;
		v[i] = 1;
		for(int l : match[i]) {
			if(b[l]==0 || dfs(b[l])) {
				b[l] = i;
				return true;
			}
		}
		return false;
	}

}
