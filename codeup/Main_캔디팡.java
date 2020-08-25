package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_캔디팡 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int result, temp;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[7][7];
		
		for(int i=0; i<7; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<7; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] v = new int[7][7];
		result = 0;
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				if(v[i][j]==0) {
					temp=0;
					dfs(i,j,map,v);
					if(temp>=3) result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int i, int j, int[][] map, int[][] v) {
		v[i][j] = 1;
		temp++;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj >= 0 && ni<7 && nj<7 && map[i][j]==map[ni][nj] && v[ni][nj]==0) {
				dfs(ni,nj,map,v);
			}
		}
	}

}
