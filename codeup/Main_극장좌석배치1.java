package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_극장좌석배치1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int result = comb(N,K);
		
		System.out.println(result);

	}
	
	public static int comb(int n, int c) {
		if(n<c) return 0;
		if(c==0) return 1;
		return comb(n-1,c-1) + comb(n-1,c);
	}
	

}
