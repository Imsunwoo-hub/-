package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_안전영역 {
	
	
	public static int result, ia[][], v[][],N;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ia = new int[N][N];
		
		int max = 0;
		int si = 0;
		int sj = 0;
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
				if(ia[i][j] > max) {
					max = ia[i][j];
				}
			}
		}
		result = 1;
		while( max > 0 ) {
			v = new int[N][N];
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(ia[i][j]>max && v[i][j]==0) {
						count++;
						dfs(i,j,max);
					}
				}
			}
			if(count > result) result = count;
			max--;
		}
		System.out.println(result);
	}
	
	public static void dfs(int i, int j, int max) {
		v[i][j] = 1;
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<N && nj>=0 && nj<N && ia[ni][nj] > max && v[ni][nj]==0) {
				dfs(ni,nj,max);
			}
		}
	}
}