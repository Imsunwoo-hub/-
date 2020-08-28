package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main_회의준비 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int INF = 100000000;
		int[][] gp = new int[N+1][N+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				gp[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++)
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(gp[i][j] > gp[i][k]+gp[k][j]) {
						gp[i][j] = gp[i][k]+gp[k][j];
					}
				}
			}
		
		int[] v = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(v[i]==0) {
				ArrayList<Integer> temp = new ArrayList<>();
				for(int j=1; j<=N; j++) {
					if(gp[i][j]!=INF || i==j) {
						v[j] = 1;
						temp.add(j);
					}
				}
				
				int min = INF;
				int idx = i;
				
				for(int t:temp) {
					int max = 0;
					for(int j=1; j<=N; j++) {
						if(t==j) continue;
						if(gp[t][j] != INF) {
							if(max < gp[t][j]) max= gp[t][j];
						}
					}
					if(max < min) {
						min = max;
						idx = t;
					}
				}

				list.add(idx);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i : list) System.out.println(i);

	}
	


}
