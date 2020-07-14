package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_동철이의일분배 {
	
	public static double result, da[][];
	public static int v[], N;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			da = new double[N][N];
			v = new int[N];
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					da[i][j] = Double.parseDouble(s[j])/100.0;
				}
			}
			result = 0.0;
			dfs(0,1.0);
			System.out.printf("#%d %f\n", tc,result);
		}
	}
	
	public static void dfs(int c, double d) {
		if(d*100<=result) return;
		if(c==N) {
			if(d*100>result) result = d*100;
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]==0) {
				v[i] = 1;
				dfs(c+1,d*da[c][i]);
				v[i]=0;
			}	
		}
	}
}
