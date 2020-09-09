package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_움직이는미로탈출 {
	
	//static char[][] map;
	static int result;
	static int[] di = {0,-1,-1, 0, 1, 1, 1,  0,-1};
	static int[] dj = {0, 0, 1, 1, 1, 0,-1, -1,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[8][8];
		
		for(int i=0; i<8; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		result = 0;
		
		dfs(7,0, map, 0);
		
		System.out.println(result);

	}
	
	public static void dfs(int i, int j, char[][] tmap, int c) {
		char[][] temp = new char[8][8];
		
		for(int a=0; a<8; a++) for(int b=0; b<8; b++) temp[a][b] = tmap[a][b];
		if(c!=0) down(temp);
		
		
		
		if(temp[i][j]=='#') return;
		
		if(cheak(temp)) {
			result = 1;
			return;
		}
		for(int d=0; d<9; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && nj>=0 && ni<8 && nj<8 && temp[ni][nj] != '#' ) {
				dfs(ni,nj,temp,1);
			}
		}
		
	}
	
	public static void down(char[][] temp) {
		for(int i=7; i>=0; i--) {
			for(int j=0; j<8; j++) {
				if(i==7) {
					if(temp[i][j]=='#') temp[i][j] = '.';
				}
				else {
					if(temp[i][j]=='#') {
						temp[i+1][j] = '#';
						temp[i][j] = '.';
					}
				}
			}
		}
	}
	
	public static boolean cheak(char[][] temp) {
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(temp[i][j] == '#') return false;
			}
		}
		
		return true;
	}

}
