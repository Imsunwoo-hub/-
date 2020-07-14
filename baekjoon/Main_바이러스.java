package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_바이러스 {
	
	static int result, N;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[N][N];
		int[] v = new int[N];
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			ia[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
			ia[Integer.parseInt(s[1])-1][Integer.parseInt(s[0])-1] = 1;
		}
		
		result = 0;
		v[0] = 1;
		for(int i=1; i<N; i++) {
			if(ia[0][i]==1 && v[i]==0) {
				dfs(i, ia, v);
			}
			
		}
	
		System.out.println(result);

	}
	
	public static void dfs(int i, int[][] ia, int[] v) {
		result++;
		v[i] = 1;
		for(int j=0; j<N; j++) {
			if(ia[i][j]==1 && v[j]==0) {
				dfs(j, ia, v);
			}
		}
	}

}
