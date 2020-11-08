package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_연결요소의개수 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] gp = new int[N+1][N+1];
		int[] v = new int[N+1];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(v[i]==0) {
				result++;
				dfs(i,gp,v);
			}
		}
		System.out.println(result);
	}
	
	public static void dfs(int i, int[][] gp, int[] v) {
		v[i] = 1;
		
		for(int j=1; j<v.length; j++) {
			if(gp[i][j]==1 && v[j]==0) {
				dfs(j, gp, v);
			}
		}
	}

}
