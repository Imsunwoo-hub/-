package beakjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class Main_저울_10159 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] gp = new int[N+1][N+1];
		int INF = 100000000;
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				gp[i][j] = INF;
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			gp[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
		for(int k=1; k<=N; k++) 
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
		
		
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(gp[i][j]==INF && gp[j][i]==INF) cnt++;
			}
			System.out.println(cnt);
		}

	}

}
