package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_색채우기 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[10][10];
		int[][] v = new int[10][10];
		
		for(int i=0; i<10; i++) {
			String s = br.readLine();
			for(int j=0; j<10; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		String[] t = br.readLine().split(" ");
		
		int x = Integer.parseInt(t[1]);
		int y = Integer.parseInt(t[0]);
		
		dfs(x,y,map,v);
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int i, int j, char[][] map, int[][] v) {
		if(map[i][j] == '*') return; 
		map[i][j] = '*';
		v[i][j] = 1;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<10 && nj<10 && v[ni][nj]==0 && map[ni][nj]=='_') {
				dfs(ni,nj,map,v);
			}
		}
	}

}
