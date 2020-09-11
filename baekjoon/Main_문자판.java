package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_문자판 {
	
	static String word;
	static int N,M,K,result,dp[][][];
	static char[][] map;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s= br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
			}
		}
		
		word = br.readLine();
		dp = new int[N][M][word.length()];
		
		for(int i=0; i<N; i++) for(int j=0; j<M; j++) Arrays.fill(dp[i][j], -1);
		
		result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==word.charAt(0)) {
					result += dfs(i,j,0);
				}
			}
		}
		
		System.out.println(result);

	}
	
	public static int dfs(int i, int j, int l) {
		if(l == word.length()-1) return dp[i][j][l] = 1;
		if(dp[i][j][l] != -1) return dp[i][j][l];
		if(map[i][j] != word.charAt(l)) return dp[i][j][l] = 0;
		
		dp[i][j][l] = 0;
			
		for(int d=0; d<4; d++) {
			for(int k=1; k<=K; k++) {
				int ni = i+di[d]*k;
				int nj = j+dj[d]*k;
				
				if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==word.charAt(l+1)) {
					dp[i][j][l] += dfs(ni,nj,l+1);
				}
			}
		}
		
		return dp[i][j][l];
		
	}

}
