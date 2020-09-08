package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_열혈강호 {
	
	static int N, M;
	static int[] v,b;
	static int[][] work;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		int cnt = 0;
		
		work = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			for(int j=1; j<=m; j++) {
				work[i][Integer.parseInt(s[j])-1] = 1; 
			}
			
		}
		b = new int[M];
		Arrays.fill(b, -1);
		v = new int[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<v.length; j++) v[j] = 0;
			if(dfs(i)) cnt++;
			
		}
		System.out.println(cnt);
	}
	
	public static boolean dfs(int i) {
		if(v[i]==1) return false;
		v[i]=1;
		
		for(int j=0; j<M; j++ ) {
			if(work[i][j]==1) {
				if(b[j]==-1 || dfs(b[j]) ) {
					b[j] = i;
					return true;
				}
			}
		}
		
		return false;
	}
}
