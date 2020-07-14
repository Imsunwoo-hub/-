package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_미로1 {
	
	public static int result, ia[][];
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			ia = new int[16][16];
			int si = 0;
			int sj = 0;
			result = 0;
			for(int i=0; i<16; i++) {
				String[] s = br.readLine().split("");
				for(int j=0; j<s.length; j++) {
					ia[i][j] = Integer.parseInt(s[j]);
					if(ia[i][j]==2) {
						si = i;
						sj = j;
					}
				}
			}
			dfs(si,sj);
			System.out.println("#"+tc+" "+result);
			
		}
	}
	
	public static void dfs(int i, int j) {
		if(ia[i][j]==3) {
			result = 1;
			return;
		}
		ia[i][j] -= 1;
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<16 && nj>=0 && nj<16 && (ia[ni][nj] ==0 || ia[ni][nj]==3)) {
				dfs(ni,nj);
			}
		}
		
	}
	
	

}
