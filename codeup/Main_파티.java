package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_파티 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int X = Integer.parseInt(s[2]);
		int INF = 1000000;
		int[][] gp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				gp[i][j] = INF;
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if(c<gp[a][b])gp[a][b] = c;
		}
		
		for(int k=1; k<=N; k++)
			for(int i=1; i<=N; i++) 
				for(int j=1; j<=N; j++)
					if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
		

		
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			if(i==X)continue;
			if(gp[i][X] + gp[X][i] > max) max = gp[i][X] + gp[X][i];
		}
		
		System.out.println(max);

	}

}
