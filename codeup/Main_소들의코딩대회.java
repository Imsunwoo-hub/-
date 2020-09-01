package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_소들의코딩대회 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int INF = 10000000;
		int[][] gp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				gp[i][j] = INF;
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			gp[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
		for(int k=1; k<=N; k++)
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k] + gp[k][j];
		
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(gp[i][j] != INF || gp[j][i] != INF) cnt++;
			}
			if(cnt==N-1) result++;
		}
		
		
		System.out.println(result);
		
	}

}
