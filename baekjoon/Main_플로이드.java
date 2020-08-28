package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_플로이드 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int INF = 1000000000;
		
		int[][] gp = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				gp[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0])-1;
			int b = Integer.parseInt(s[1])-1;
			int c = Integer.parseInt(s[2]);
			if(c< gp[a][b])gp[a][b] = c;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(gp[i][j] > gp[i][k] + gp[k][j]) gp[i][j] = gp[i][k] + gp[k][j];
				}
			}
		}
	
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(gp[i][j] >= INF) System.out.print("0 ");
				else System.out.print(gp[i][j]+" ");
			}
			System.out.println();
		}
	

	}

}
