package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_섬의개수 {
	
	public static int count, N, M, ia[][], v[][];
	
	public static int[] di = {-1,-1,0,1,1, 1, 0,-1};
	public static int[] dj = { 0, 1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
	
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		if(N==0 && M==0) break;
		ia = new int[N][M];
		v = new int[N][M];
		for(int i=0; i<N; i++ ) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
			}
		}
		count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ia[i][j]==1 && v[i][j]==0 ) {
					
					count++;
					dfs(i,j);
				}
			}
		}
			System.out.println(count);
		}
	}

	public static void dfs(int i, int j) {
		v[i][j] = 1;
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<M && ia[ni][nj]==1 && v[ni][nj]==0) {
				dfs(ni,nj);
			}
		}
	}
}
