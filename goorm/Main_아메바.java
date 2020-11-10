package goorm;

import java.io.*;

public class Main_아메바 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[2];
		ia[1] = 1;
		
		while(N>0){
			N--;
			int man = ia[0];
			int woman = ia[1];
			ia[0] += (woman+man)-man;
			ia[1] -= (woman-1);
			ia[1] += man;
		}
		
		System.out.println(ia[0]+" "+ia[1]);
	}
}
