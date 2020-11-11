package goorm;

import java.io.*;
public class Main_특정구간의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++){
			if(i==0){
				ia[i] = Integer.parseInt(s[i]);
			}
			else{
				ia[i] = ia[i-1]+Integer.parseInt(s[i]);
			}
		}
		
		s = br.readLine().split(" ");
		
		int start = Integer.parseInt(s[0])-1;
		int end = Integer.parseInt(s[1])-1;
		
		if(start==0){
			System.out.println(ia[end]);
		}
		else {
			System.out.println(ia[end]-ia[start-1]);
		}
		
		
	}
}