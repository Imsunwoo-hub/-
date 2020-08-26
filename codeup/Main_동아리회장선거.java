package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_동아리회장선거 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		
		powerset(0, ia);
		

	}
	
	public static void powerset(int n, int[] ia) {
		if(n==ia.length) {
			for(int i=0; i<ia.length; i++) {
				if(ia[i]==0) System.out.print("O");
				else System.out.print("X");
			}
			System.out.println();
			return;
		}
		ia[n] = 0;
		powerset(n+1, ia);
		ia[n] = 1;
		powerset(n+1, ia);
	}

}
