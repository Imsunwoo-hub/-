package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_인터넷설치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int INF = Integer.MAX_VALUE/2;
		int[][] gp = new int[N+1][N+1];
		int min = -1;
		int[] d = new int[N+1];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			gp[a][b] = c;
			gp[b][a] = c;
		}
		
		int l = 0;
		int r = 10000000;
		
		while(l<=r) {
			int mid = (l+r)/2;
			setting(INF, d, N);
			
			if(dijkstra(gp,d,N,mid,K)) {
				min = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
			//System.out.println(Arrays.toString(d));
			
		}
		System.out.println(min);
		
	}
	
	
	public static void setting(int inf, int[] d, int N) {
		for(int i=1; i<=N; i++) {
			d[i] = inf;
		}
		d[1] = 0;
	}
	
	public static boolean dijkstra(int[][] gp, int[] d, int N, int x, int K) {
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {1,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(d[curr[0]] < curr[1] ) continue;
			
			for(int i=1; i<=N; i++) {
				if(gp[curr[0]][i]==0) continue;
				int cost = curr[1] + (gp[curr[0]][i] > x ? 1:0);
				if(d[i] > cost) {
					d[i] = cost;
					q.offer(new int[] {i,d[i]});
				}
			}
		}
		//System.out.println(Arrays.toString(d));
		if(d[N]<=K) return true;
		return false;
	}

}
