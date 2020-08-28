package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_경로찾기 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int INF = 100000000;
		
		int[][] gp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				gp[i][j] = Integer.parseInt(s[j]);
				if(gp[i][j]==0) gp[i][j] = INF;
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(gp[i][j]>gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(gp[i][j]==INF) System.out.print("0 "); 
				else System.out.print("1 ");
			}
			System.out.println();
		}
		
	}
	
}
