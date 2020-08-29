package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_맥주마시면서걸어가기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] ia = new int[N+2][2];
			
			for(int i=0; i<N+2; i++) {
				String[] s = br.readLine().split(" ");
				ia[i][0] = Integer.parseInt(s[0]);
				ia[i][1] = Integer.parseInt(s[1]);
			}
			
			int[][] gp = new int[N+2][N+2];
			int INF = 10000000;
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==j) gp[i][j] = INF;
					else if(Math.abs(ia[i][0]-ia[j][0])+Math.abs(ia[i][1]-ia[j][1])<=1000) gp[i][j] = 1;
					else gp[i][j] = INF;
				}
			}
			
			for(int k=0; k<N+2; k++)
				for(int i=0; i<N+2; i++)
					for(int j=0; j<N+2; j++)
						if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
			
			if(gp[0][ia.length-1]<INF) System.out.println("happy");
			else System.out.println("sad");
		}

	}

}
