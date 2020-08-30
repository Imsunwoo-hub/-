package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_촌수계산  {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		
		int INF = 10000000;
		int[][] gp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				gp[i][j] = INF;
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++)
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
		
		
		if(gp[x][y] == INF) System.out.println("-1");
		else System.out.println(gp[x][y]);
		
	}

}
