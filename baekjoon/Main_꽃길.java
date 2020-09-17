package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_꽃길 {
	
	static int N, result;
	static int[][] ia, v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ia = new int[N][N];
		v = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		result = Integer.MAX_VALUE;
		
		dfs(0,0);
		
		System.out.println(result);
		
	}
	
	public static void dfs(int cnt, int temp) {
		if(cnt==3) {
			if(result > temp) result = temp;
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int bol = 0;
				int sum = ia[i][j];
				for(int d=0; d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni<0 || nj<0 || ni>=N || nj>=N || v[ni][nj]==1) {
						bol = 1;
						break;
					}
					sum += ia[ni][nj];
				}
				if(bol==0) {
					v[i][j] = 1;
					for(int d=0; d<4; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						v[ni][nj] = 1;
					}
					dfs(cnt+1, temp+sum);
					v[i][j] = 0;
					for(int d=0; d<4; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						v[ni][nj] = 0;
					}
				}
			}
		}
	}

}
