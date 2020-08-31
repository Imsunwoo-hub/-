package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


class Node {
	
	int E;
	int W;
	
	Node(int E, int W){
		this.E = E;
		this.W = W;
	}
}

public class Main_최단경로 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int INF = Integer.MAX_VALUE/2;
		
		ArrayList<Node>[] list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			list[Integer.parseInt(s[0])].add(new Node(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
		}

		int[] d = new int[N+1];
		int[] v = new int[N+1];
		for(int i=1; i<N+1; i++) d[i] = INF;
		
		d[start] = 0;
	
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]]==1) continue;
			v[curr[0]] = 1;
			
			for(Node n : list[curr[0]]) {
				if(d[n.E] > d[curr[0]] + n.W) {
					d[n.E] = d[curr[0]] + n.W;
					q.offer(new int[] {n.E, d[n.E]});
				}
			}
			
		}
		
		
		for(int i=1; i<=N; i++) {
			if(d[i]==INF)System.out.println("INF");
			else System.out.println(d[i]);
		}
		
		

	}

}
