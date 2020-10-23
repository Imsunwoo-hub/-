package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_적록색약 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int cnt, N, v[][];
	static char[][] map; 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}	
		}
		int[] result = new int[2];
		cnt = 0;
		v = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]==0) {
					char c = map[i][j];
					cnt++;
					dfs(i,j,c,0);
				}
			}
		}
		result[0] = cnt;
		cnt = 0;
		v = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]==0) {
					char c = map[i][j];
					cnt++;
					dfs(i,j,c, 1);
				}
			}
		}
		result[1] = cnt;
		
		System.out.println(result[0]+" "+result[1]);

	}
	
	public static void dfs(int i, int j, char c, int bol) {
		v[i][j] = 1;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0) {
				if(bol == 0) {
					if(c==map[ni][nj]) {
						dfs(ni,nj,c,bol);
					}
				}
				else {
					if(c =='B') {
						if(map[ni][nj]==c) {
							dfs(ni,nj,c,bol);
						}
					}
					else {
						if(map[ni][nj] != 'B') {
							dfs(ni,nj,c,bol);
						}
					}
				}
			}
		}
		
	}

}
