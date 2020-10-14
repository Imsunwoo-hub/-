package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		System.out.println(dfs(N));
	}
	
	public static long dfs(int N) {
		if(N<=1) return 1;
		return N * dfs(N-1);
		
	}

}
