package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_PuyoPuyo {
	
	static char[][] map;
	static int[][] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int temp;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		
		for(int i=0; i<12; i++) {
			String s = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int result = 0;
		v = new int[12][6];
		
		while(true) {
			int bol = 0;
			clear();
			for(int i=11; i>=0; i--) {
				for(int j=0; j<6; j++) {
					if(map[i][j]!='.' && v[i][j]==0) {
						temp=0;
						dfs(i,j,map[i][j]);
						if(temp>=4) {
							bol = 1;
							boom(i,j,map[i][j]);
						}
					}
				}
			}
			if(bol==1) {
				down();
				result++;
			}
			else break;
		}
		
		System.out.println(result);
		
	}
	
	public static void boom(int i, int j, char c) {
		//System.out.println(c);
		map[i][j] = '.';
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<12 && nj<6 && map[ni][nj]==c) {
				boom(ni,nj,c);
			}
		}
	}
	
	public static void dfs(int i, int j, char c) {
		v[i][j] = 1;
		temp++;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<12 && nj<6 && v[ni][nj]==0 && map[ni][nj]==c) {
				dfs(ni,nj,c);
			}
		}
		
	}
	
	public static void clear() {
		for(int i=0; i<v.length; i++) {
			for(int j=0; j<v[0].length; j++) {
				v[i][j] = 0;
			}
		}
	}
	
	public static void down() {
		for(int i=11; i>=0; i--) {
			for(int j=0; j<6; j++) {
				if(map[i][j]!='.') {
					int ni = i;
					while(true) {
						if(ni+di[1] > 11 || map[ni+di[1]][j] !='.') break;
						ni += di[1];
					}
					if(i!=ni) {
						map[ni][j] = map[i][j];
						map[i][j] = '.';						
					}
				}
			}
		}
	}

}
