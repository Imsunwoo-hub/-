package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int INF = Integer.MAX_VALUE/2;
		int[][] gp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) for(int j=1; j<=N; j++) gp[i][j] = INF;
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(gp[i][j] > gp[i][k]+gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
				}
			}
		}
		
		int min = INF;
		int idx = -1;
		
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				sum += gp[i][j];
			}
			if(sum < min) {
				idx = i;
				min = sum;
			}
		}
		System.out.println(idx);

	}

}
