package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_호수의수구하기 {
	
	static int W,H;
	static int[][] v;
	static char[][] map;
	static int[] di = {-1,-1,0,1,1, 1, 0,-1};
	static int[] dj = { 0, 1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		W = Integer.parseInt(s[0]);
		H = Integer.parseInt(s[1]);
		
		map = new char[H][W];
		v = new int[H][W];
		
		for(int i=0; i<H; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<W; j++) {
				map[i][j] = s[j].charAt(0);
			}
		}
		
		int result = 0;
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]=='L' && v[i][j]==0) {
					result++;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int j) {
		v[i][j] = 1;
		
		for(int d=0; d<8; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj]=='L' && v[ni][nj] == 0 ) {
				dfs(ni,nj);
			}
		}
		
	}

}
