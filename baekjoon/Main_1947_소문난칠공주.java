package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_1947_소문난칠공주 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static char[][] map;
	static int[] vmap[], v, tv[];
	static int cnt, result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		result = 0;
		
		for(int i=0; i<25; i++) {
			vmap = new int[5][5];
			v = new int[25];
			dfs(i,1,0);
		}
		
		System.out.println(result);
		
	}
	public static void dfs(int n, int c, int s) {
		if(map[n/5][n%5]=='S') {
			s = s+1;
		}
		v[n] = 1;
		vmap[n/5][n%5] = 1;
		
		if(c==7) {
			if(s>=4) {
				bol();
			}
		}else {
			for(int i=n+1; i<25; i++) {
				if(v[i]==0) {
					dfs(i,c+1,s);
				}
			}
		}
		v[n] = 0;
		vmap[n/5][n%5] = 0;
	}
	
	public static void bol() {
		for(int i=0; i<25; i++) {
			if(v[i]==1) {
				int a = i/5;
				int b = i%5;
				tv = new int[25][25];
				tv[a][b] = 1;
				cnt = 1;
				count(a,b);
				return;
			}
		}
	}
	
	public static void count(int i, int j) {
		if(cnt==7) {
			result++;
			return;
		}
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<5 && nj<5 && tv[ni][nj]==0 && vmap[ni][nj]==1) {
				tv[ni][nj] = 1;
				cnt++;
				count(ni,nj);
			}
		}
	}
	
}
