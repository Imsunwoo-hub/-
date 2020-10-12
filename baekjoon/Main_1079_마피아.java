package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1079_마피아 {
	
	static int result, mafia, N, bol;
	static int[] point, R[]; 

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		point = new int[N];
		R = new int[N][N];
		String[] s = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(i);
			point[i] = Integer.parseInt(s[i]); 
		}
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				R[i][j] = Integer.parseInt(s[j]);
			}
		}
		bol = 0;
		mafia = Integer.parseInt(br.readLine());
		result = 0;
		dfs(N,0);
		System.out.println(result);
	
	}
	
	public static void dfs(int p, int c) {
		if(bol==1) return;
		if(point[mafia] == 0 || p==1) {
			if(c>result) result = c;
			if(point[mafia] !=0 && p==1) {
				bol = 1;
			}
			return;
		}
		
		
		if(p%2==0) {
			for(int i=0; i<N; i++) {
				if(i != mafia && point[i] !=0 ) {
					int temp = point[i];
					point[i] = 0;
					for(int j=0; j<N; j++) {
						if(point[j] !=0 && i!=j) {
							point[j] += R[i][j]; 
						}
					}
					dfs(p-1, c+1);
					if(bol == 1) return;
					for(int j=0; j<N; j++) {
						if(point[j] !=0 && i!=j) {
							point[j] -= R[i][j]; 
						}
					}
					point[i] = temp;
				}
			}
		}
		else {
			int min = Integer.MIN_VALUE;
			int idx = 0;
			for(int i=0; i<N; i++) {
				if(point[i] > min) {
					min = point[i];
					idx = i;
				}
			}
			int temp = point[idx];
			point[idx] = 0;
			dfs(p-1, c);
			if(bol==1) return;
			point[idx] = temp;
		}
		
		
	}

}
