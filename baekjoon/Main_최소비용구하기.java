package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Bus {
	
	int end;
	int cost;
	
	Bus(int end, int cost){
		this.end = end;
		this.cost = cost;
	}
	
}

public class Main_최소비용구하기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;
		
		ArrayList<Bus>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			list[Integer.parseInt(s[0])].add(new Bus(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
		
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		
		int[] d = new int[N+1];
		int[] v = new int[N+1];
		
		for(int i=1; i<=N; i++) d[i] = INF;
		
		d[start] = 0;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {start,0});
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			
			if(v[curr[0]]==1) continue;
			v[curr[0]] = 1;
			
			for(Bus b : list[curr[0]]) {
				if(d[b.end] > d[curr[0]] + b.cost) {
					d[b.end] = d[curr[0]] + b.cost;
					q.offer(new int[] {b.end, d[b.end]});
				}
			}
			
		}
	
		System.out.println(d[end]);
		
	}
}
