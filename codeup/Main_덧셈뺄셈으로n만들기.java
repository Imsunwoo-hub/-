package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_덧셈뺄셈으로n만들기 {
	
	static int result;

	public static void main(String[] args) throws Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] ia = new int[N];
	
		
		for(int i=0; i<N; i++) {
			ia[i] = sc.nextInt();
		}
		result = 0;
		
		dfs(0,0,N,M,ia);
		
		System.out.println(result);

	}
	
	public static void dfs(int i, int temp, int n, int m, int[] ia) {
		if(i>=n) {
			if(temp==m) result++;
			return;
		}
		dfs(i+1, temp+ia[i], n,m,ia);
		dfs(i+1, temp-ia[i], n,m,ia);
	}

}
