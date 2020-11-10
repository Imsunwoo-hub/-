package goorm;

import java.io.*;
public class Main_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[21];
		
		for(int i=0; i<N; i++){
			String[] s = br.readLine().split(" ");
			
			if(s[0].equals("add")){
				ia[Integer.parseInt(s[1])] = 1;
			} else if(s[0].equals("remove")){
				ia[Integer.parseInt(s[1])] = 0;
			}else if(s[0].equals("check")){
				if(ia[Integer.parseInt(s[1])] == 1) System.out.println(1);
				else System.out.println(0);
			}else if(s[0].equals("toggle")){
				if(ia[Integer.parseInt(s[1])] == 1) ia[Integer.parseInt(s[1])] =0;
				else ia[Integer.parseInt(s[1])] = 1;
			}else if(s[0].equals("all")){
				for(int j=1; j<=20; j++) ia[j] = 1;
			} else {
				for(int j=1; j<=20; j++) ia[j] = 0;
			}
		}
	}
}
