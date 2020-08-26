package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_두노드간거리 {
	
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		
		System.out.println(f(a,b));
	}
	
	public static int f(int a, int b) {
		if(a==b) return 0;
		if(a>b) return f(a/2, b) +1;
		return f(a,b/2) +1;
	}
}
