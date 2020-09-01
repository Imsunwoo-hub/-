package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node{
	int end;
	int cost;
	Node(int end, int cost){
		this.end = end;
		this.cost = cost;
	}
}


public class Main_망가진부품 {
	


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int D = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			
			
			int INF = Integer.MAX_VALUE;
			
			ArrayList<Node>[] list = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
			
			int[] d = new int[N+1];
			int[] v = new int[N+1];
			
			for(int i=1; i<=N; i++) d[i] = INF;
			
			for(int i=0; i<D; i++) {
				s = br.readLine().split(" ");
				list[Integer.parseInt(s[1])].add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[2])));
			}
			
			d[C] = 0;
			
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					
					return Integer.compare(o1[1], o2[1]);
				}
			});
			
			q.offer(new int[] {C,d[C]});
			
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				
				if(v[curr[0]]==1) continue;
				v[curr[0]]=1;
				
				for(Node n : list[curr[0]]) {
					if(d[n.end] > d[curr[0]]+n.cost) {
						d[n.end] = d[curr[0]]+n.cost;
						q.offer(new int[] {n.end, d[n.end]});
					}
				}
			}
			
			int count = 0;
			int max = 0;
			
			for(int i=1; i<=N; i++) {
				if(d[i] != INF) {
					count++;
					if(max<d[i]) max = d[i];
				}
			}
			
			System.out.println(count+" "+max);
			
		}
		
	}

}
