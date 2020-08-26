package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_계단오르기 {
	
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		result = 0;
		
		dfs(0, N);
		
		System.out.println(result);

	}
	
	public static void dfs(int c, int n) {
		if(c>n) return;
		if(c==n) {
			result++;
			return;
		}
		dfs(c+1, n);
		dfs(c+2, n);
	}

}
