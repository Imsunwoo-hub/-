package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_최장경로 {
	
	static int N, result;
	static int[] ia[], v;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_2814.txt"));
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			ia = new int[N][N];
			v = new int[N];
			for(int i=0; i<M; i++) {
				String[] t = br.readLine().split(" ");
				ia[Integer.parseInt(t[0])-1][Integer.parseInt(t[1])-1] = 1;
				ia[Integer.parseInt(t[1])-1][Integer.parseInt(t[0])-1] = 1;
			}
			result = 1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(ia[i][j] == 1) {
						v[i] = 1;
						v[j] = 1;
						dfs(j, 2);
						v[i] = 0;
						v[j] = 0;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void dfs(int i, int c) {
		if(c > result) result = c;
		for(int j=0; j<N; j++) {
			if( v[j] == 0 && ia[i][j] == 1 ) {
				v[j]=1;
				dfs(j, c+1);
				v[j]=0;
			}
		}
	}

}
