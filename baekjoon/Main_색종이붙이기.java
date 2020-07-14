package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_색종이붙이기 {
	
	static int[][] ia;
	static int[] count = {0,5,5,5,5,5};
	static int result;

	public static void main(String[] args) throws Exception {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
			
			ia = new int[10][10];
			
			
			for(int i=0; i<10; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<10; j++) {
					ia[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			result = Integer.MAX_VALUE;
			dfs(0,0);
			
			
			if(result==Integer.MAX_VALUE) result = -1;
			System.out.println(result);
		
		
	}
	
	public static void dfs(int idx, int c) {
		if(idx==100) {
			int bol = 0;
			for(int a=0; a<10; a++) {
				for(int b=0; b<10; b++) {
					if(ia[a][b]==1) {
						bol = 1;
						break;
					}
				}
			}
			if(bol==0) {
				if(result > c) result= c;
			}
			return;
		}
		if(c>result) return;
		int i = idx/10;
		int j = idx%10;
		if(ia[i][j] == 1) {
			for(int s=5; s>=1; s--) {
				if(count[s]>0) {
					if(backtrack(i,j,s)) {
						for(int a=i; a<i+s; a++) {
							for(int b=j; b<j+s; b++) {
								ia[a][b] = 0;
							}
						}
						count[s]--;
						dfs(idx+1, c+1);
						count[s]++;
						for(int a=i; a<i+s; a++) {
							for(int b=j; b<j+s; b++) {
								ia[a][b] = 1;
							}
						}
					}
				}
			}
		}
		else {
			dfs(idx+1, c);
		}
	}
	
	public static boolean backtrack(int i, int j, int s) {
		if(i+s>10 || j+s>10) return false;
		for(int a=i; a<i+s; a++) {
			for(int b=j; b<j+s; b++) {
				if(ia[a][b] != 1) return false;
			}
		}
		return true;
	}

}
