package 백준단계별로풀어보기.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1504_특정한최단경로 {
	
	static int INF, N, gp[][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		INF = 200000005;
		
		gp = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			gp[a][b] = c;
			gp[b][a] = c;
		}
		
		s = br.readLine().split(" ");
		
		
		int v1 = Integer.parseInt(s[0]);
		int v2 = Integer.parseInt(s[1]);
		
		int[] d = new int[N+1];
		int[] d1 = new int[N+1];
		int[] d2 = new int[N+1];
		
		Arrays.fill(d, INF);
		Arrays.fill(d1, INF);
		Arrays.fill(d2, INF);
		
		dijkstra(1,d);
		dijkstra(v1,d1);
		dijkstra(v2,d2);
//		System.out.println(Arrays.toString(d));
//		System.out.println(Arrays.toString(d1));
//		System.out.println(Arrays.toString(d2));
		int result = 0;
		if(d[v1]==INF || d1[N]==INF || d1[v2]==INF || d[v2]==INF || d2[N]==INF|| d2[v1]==INF) System.out.println(-1);
		else {
			result = Math.min(d[v1]+d1[v2]+d2[N],d[v2]+d2[v1]+d1[N] );
			System.out.println(result);
		}
		
	}
	
	public static void dijkstra(int start, int[] d) {
		d[start] = 0;
		int[] v = new int[N+1];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		q.offer(new int[] {start,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]]==0) {
				v[curr[0]]=1;
				for(int i=1; i<=N; i++) {
					if(gp[curr[0]][i]==0) continue;
					if(d[i] > gp[curr[0]][i] + curr[1]) {
						d[i] = gp[curr[0]][i] + curr[1];
						q.offer(new int[] {i,d[i]});
					}
				}
			}
		}
	}

}
