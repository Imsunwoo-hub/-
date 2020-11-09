package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_회장뽑기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] gp = new int[N+1][N+1];
		
		int inf = 10000;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				gp[i][j] = inf;
			}
		}
		
		while(true) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if(a==-1 && b==-1) break;
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(gp[i][j] > gp[i][k] + gp[k][j]) gp[i][j] = gp[i][k]+gp[k][j];
				}
			}
		}
		ArrayList<Integer>[] list = new ArrayList[N+2];
		for(int i=1; i<=N+1; i++) list[i] = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			int max = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(gp[i][j] > max) max = gp[i][j];
			}
			
			if(max != inf) {
				list[max].add(i);
			}
		}
		int idx = 0;
		int size = 0;
		for(int i=1; i<=N+1; i++) {
			if(list[i].size()!=0) {
				idx = i;
				size = list[i].size();
				break;
			}
		}
		
		System.out.println(idx + " "+ size);
		for(int i : list[idx]) System.out.print(i+" ");

	}

}
