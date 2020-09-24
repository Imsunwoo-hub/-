package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_계단오르기1 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N+1];
		ia[0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<4; j++) {
				if(i-j >= 0) ia[i] = ((ia[i]%1000) +(ia[i-j]%1000))%1000;
			}
		}
		
		System.out.println(ia[N]%1000);
	}

}
