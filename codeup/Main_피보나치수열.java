package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_피보나치수열 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(f(N));

	}
	
	public static int f(int n) {
		if(n<=2) return 1;
		return f(n-2)+f(n-1);
	}

}
