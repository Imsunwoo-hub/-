package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_선발명단 {
	
	static int result;
	static int[] v, ia[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			ia = new int[11][11];
			v= new int[11];
			
			for(int i=0; i<11; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<11; j++) {
					ia[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			result = 0;
			
			dfs(0,0);
			
			System.out.println(result);
		}
		
	}
	
	public static void dfs(int i, int sum) {
		if(i==11) {
			if(sum > result) result = sum;
			return;
		}
		for(int j=0; j<11; j++) {
			if(ia[i][j] != 0 && v[j]==0) {
				v[j] = 1;
				dfs(i+1, sum+ia[i][j]);
				v[j] = 0;
			}
		}
	}

}
