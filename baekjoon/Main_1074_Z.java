package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1074_Z {
	
	static int value;
	static int result,r,c;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);
		c = Integer.parseInt(s[2]);
		int size = (int)Math.pow(2, N);
		result = -1;
		value = 0;
		dfs(0,0,size);
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int j, int n) {
		if(result != -1) return;
		if(n==1) {
			if(i==r && j==c) result = value;
			value++;
			return;
		}
		int nn = n/2;
		dfs(i,j,nn);
		dfs(i,j+nn,nn);
		dfs(i+nn,j,nn);
		dfs(i+nn,j+nn,nn);
	}

}
