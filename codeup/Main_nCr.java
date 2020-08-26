package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_nCr {
	
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int R = Integer.parseInt(s[1]);
		
		result = 0;
		f(N,R);
		
		System.out.println(result);

	}
	
	public static void f(int n, int r) {
		if(n<r) return;
		if(r==0) {
			result++;
			return;
		}
		f(n-1,r-1);
		f(n-1,r);
	}

}
