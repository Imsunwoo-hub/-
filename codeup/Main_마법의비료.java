package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_마법의비료 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map, v;
	static int N, M, cnt;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		v = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		double result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && v[i][j] == 0) {
					cnt = 0;
					dfs(i,j);
					result += Math.sqrt(cnt);
				}
			}
		}
		
		String answer = String.format("%.4f", result);
		
		System.out.println(answer);
	}
	
	public static void dfs (int i, int j) {
		cnt++;
		v[i][j] = 1;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==1 && v[ni][nj]==0) {
				dfs(ni,nj);
			}
		}
	}

}
