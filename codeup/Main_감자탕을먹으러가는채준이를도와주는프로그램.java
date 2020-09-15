package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_감자탕을먹으러가는채준이를도와주는프로그램 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0])-1;
		int end = Integer.parseInt(s[1])-1;
		int a = 0;
		int b = 0;
		int idx = start;
		while(true) {
			
			a+=ia[idx];
			idx++;
			if(idx == N) idx = 0;
			if(idx==end) break;
		}
		idx = start;
		while(true) {
			if(idx==end) break;
			idx--;
			if(idx == -1) idx = N-1;
			b+=ia[idx];	
		}
		
		System.out.println(Math.min(a, b));
		
	}

}
