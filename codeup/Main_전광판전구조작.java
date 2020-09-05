package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_전광판전구조작 {
	
	static int N, M, on, off;
	static int[][] onMap, offMap;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		onMap = new int[N][M];
		offMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				onMap[i][j] = Integer.parseInt(s[j]);
				offMap[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(onMap[i][j]==0) {
					on++;
					dfs(i,j,onMap, 0);
				}
				if(offMap[i][j]==1) {
					off++;
					dfs(i,j,offMap, 1);
				}
			}
		}


		System.out.println(on+" "+off);
		
		

	}
	
	public static void dfs(int i, int j, int[][] map, int x) {
		map[i][j] = (x+1)%2;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==x) {
				dfs(ni, nj, map, x);
			}
		}
	}

}
