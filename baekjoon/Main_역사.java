package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_역사 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int INF = 100000000;
		int[][] gp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				gp[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			gp[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(gp[i][j]> gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		
		for(int i=0; i<S; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);			
			if(gp[a][b]==INF && gp[b][a]==INF) System.out.println("0");
			else if(gp[a][b]!=INF && gp[b][a]==INF) System.out.println("-1");
			else System.out.println("1");
		}

	}

}
