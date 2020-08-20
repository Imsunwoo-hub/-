package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_체커도전 {
	
	static int[] v, map[];
	static int N, result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		v = new int[N];
		map = new int[N][N];
		
		result = 0;
		
		dfs(0, "");
		
		System.out.println(result);

	}
	
	static void dfs(int i, String temp) {
		if(i>=N) {
			result++;
			if(result <= 3) System.out.println(temp);
			return;
		}
		
		for(int j=0; j<N; j++) {
			if(v[j]==0 && backtracking(i,j)) {
				v[j] = 1;
				map[i][j] = 1;
				dfs(i+1, temp+(j+1)+" ");
				v[j] = 0;
				map[i][j] = 0;
			}
		}
	}
	
	static boolean backtracking(int i, int j) {
		
		for(int a=0; a<N; a++) {
			if(map[a][j]==1) return false;
		}
		for(int b=0; b<N; b++) {
			if(map[i][b]==1) return false;
		}
		for(int a=0; a<N; a++) {
			if(i-a < 0 || j-a < 0) break;
			if(map[i-a][j-a]==1) return false;
		}
		for(int a=0; a<N; a++) {
			if(i+a >= N || j+a >= N) break;
			if(map[i+a][j+a]==1) return false;
		}
		for(int a=0; a<N; a++) {
			if(i-a < 0 || j+a >= N) break;
			if(map[i-a][j+a]==1) return false;
		}
		for(int a=0; a<N; a++) {
			if(i+a >=N || j-a < 0) break;
			if(map[i+a][j-a]==1) return false;
		}
		
		return true;
	}
}
