package goorm;

import java.io.*;
import java.util.*;

public class Main_길찾기다이아몬드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 2*N-1;
		
		ArrayList<Integer>[] list = new ArrayList[M];
		ArrayList<Integer>[] dp = new ArrayList[M];
		
		for(int i=0; i<M; i++) {
			list[i] = new ArrayList<>();
			dp[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			String[] s = br.readLine().split(" ");
			for(int j=0; j<s.length; j++){
				list[i].add(Integer.parseInt(s[j]));
				dp[i].add(0);
			}
		}
		dp[0].set(0, list[0].get(0));
		
		for(int i=1; i<M; i++){
			if(i < N){
				for(int j=0; j<dp[i].size(); j++){
					if(j==0){
						dp[i].set(j, dp[i-1].get(j)+list[i].get(j));
					}
					else if(j==dp[i].size()-1){
						dp[i].set(j, dp[i-1].get(j-1)+list[i].get(j));
					}
					else {
						int x = Math.max(dp[i-1].get(j) +list[i].get(j),dp[i-1].get(j-1) +list[i].get(j));
						dp[i].set(j,x);
					}
				}
			}
			else {
				for(int j=0; j<dp[i].size(); j++){
					int x = Math.max(dp[i-1].get(j)+list[i].get(j),dp[i-1].get(j+1)+list[i].get(j));
					dp[i].set(j,x);
				}
			}
		}
		
		//for(ArrayList<Integer> l:dp) System.out.println(l);
	
		System.out.println(dp[M-1].get(0));
	}
}
