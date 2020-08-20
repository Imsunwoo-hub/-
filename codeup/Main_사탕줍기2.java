package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_사탕줍기2 {
	
	static int result, N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int[] v = new int[N];
		result = 0;
		dfs(0, map, v, 0);
		System.out.println(result);

	}
	
	public static void dfs(int i, int[][] map, int[] v, int temp) {
		if(i>=N) {
			if(result < temp) result = temp;
			return;
		}
		for(int j=0; j<N; j++) {
			if(v[j]==0) {
				v[j] = 1;
				dfs(i+1, map, v, temp+map[i][j]);
				v[j] = 0;
			}
		}
	}

}
