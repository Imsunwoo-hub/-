package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Road {
	int end;
	int cost;
	Road(int end, int cost){
		this.end = end;
		this.cost = cost;
	}
}

public class Main_도로포장 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		long INF = Long.MAX_VALUE;
		
		ArrayList<Road>[] list = new ArrayList[N+1];
		
		long[][] d = new long[N+1][K+1];
		int[][] v = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		for(int i=1; i<=N; i++) for(int j=0; j<=K; j++) d[i][j] = INF;
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			list[a].add(new Road(b,c));
			list[b].add(new Road(a,c));
		}
		
		d[1][0] = 0;
		
		PriorityQueue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				
				return Long.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new long[] {1,0,0});
		
		while(!q.isEmpty()) {
			long[] curr = q.poll();
			
			if(v[(int) curr[0]][(int)curr[2]]==1) continue;
			v[(int)curr[0]][(int)curr[2]]=1;
			
			for(Road r : list[(int)curr[0]]) {
				if(curr[2]+1 <= K && d[r.end][(int)curr[2]+1] > d[(int)curr[0]][(int)curr[2]]) {
					d[r.end][(int)curr[2]+1] = d[(int)curr[0]][(int)curr[2]];
					q.offer(new long[] {r.end ,d[r.end][(int)curr[2]+1] ,curr[2]+1});
				}
				if(d[r.end][(int)curr[2]] > d[(int)curr[0]][(int)curr[2]] + r.cost) {
					d[r.end][(int)curr[2]] = d[(int)curr[0]][(int)curr[2]] + r.cost;
					q.offer(new long[] {r.end, d[r.end][(int)curr[2]], curr[2]});
				}
			}
		}
		
		long min = Long.MAX_VALUE;
		
		for(int i=0; i<=K; i++) if(min > d[N][i]) min = d[N][i];
		
		System.out.println(min);
		
	}

}
