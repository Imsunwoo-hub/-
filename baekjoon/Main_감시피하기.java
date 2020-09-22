package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_감시피하기 {
	
	static int N;
	static String result;
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static ArrayList<int[]> tlist, xlist;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		tlist = new ArrayList<>();
		xlist = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = s[j].charAt(0);
				if(map[i][j]=='T') tlist.add(new int[] {i,j});
				if(map[i][j]=='X') xlist.add(new int[] {i,j});
			}
		}
		
		result = "NO";
		dfs(0,0);
		
		System.out.println(result);
	}
	
	public static void dfs(int n, int c) {
		if(c==3) {
			for(int[] t:tlist) {
				for(int d=0; d<4; d++) {
					int ni = t[0];
					int nj = t[1];
					while(true) {
						ni += di[d];
						nj += dj[d];
						
						if(ni<0 || nj<0 || ni>=N || nj>=N || map[ni][nj]=='W') break;
						if(map[ni][nj]=='S') {
							return;
						}
					}
				}
			}
			result = "YES";
			return;
		}
		if(n==xlist.size()) return;
		map[xlist.get(n)[0]][xlist.get(n)[1]] = 'W';
		dfs(n+1, c+1);
		map[xlist.get(n)[0]][xlist.get(n)[1]] = 'X';
		dfs(n+1, c);
	}

}
