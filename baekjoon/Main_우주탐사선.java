package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_우주탐사선 {
	
	static int N, result;
	static int[] v, ia[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		int start = Integer.parseInt(s[1]);
		
		ia = new int[N][N];
		v = new int[N];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				int x = Integer.parseInt(s[j]);
				if(x!=0) ia[i][j] = x;
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(ia[i][j] > ia[i][k]+ia[k][j]) ia[i][j] = ia[i][k]+ia[k][j];
				}
			}
		}
		
		v[start] = 1;
		result = Integer.MAX_VALUE;
		dfs(start, 0, 1);
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int temp, int cnt) {
		if(temp > result) return;
		if(cnt == N) {
			if(temp<result) result = temp;
			return;
		}
		
		for(int j=0; j<N; j++) {
			if(v[j]==0) {
				v[j] = 1;
				dfs(j,temp+ia[i][j], cnt+1);
				v[j] = 0;
			}
		}
	}

}
