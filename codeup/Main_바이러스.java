package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_바이러스 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] gp = new int[N+1][N+1];
		
		int[] d = new int[N+1];
		int[] v = new int[N+1];
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			gp[a][b] = 1;
			gp[b][a] = 1;
		}
		
		for(int i=1; i<=N; i++) d[i] = Integer.MAX_VALUE/2;
		
		d[1] = 0;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {1,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]]==1) continue;
			v[curr[0]] = 1;
			
			for(int i=1; i<=N; i++) {
				if(gp[curr[0]][i]==0) continue;
				if(d[i] > d[curr[0]] + gp[curr[0]][i]) {
					d[i] = d[curr[0]] + gp[curr[0]][i];
					q.offer(new int[] {i,d[i]});
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) if(i != 1 && d[i] != Integer.MAX_VALUE/2) cnt++;
		System.out.println(cnt);
	}

}
