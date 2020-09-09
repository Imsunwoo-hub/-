package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_최소스패닝트리 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] p = new int[N+1];
		
		for(int i=1; i<=N; i++) p[i] = i;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			q.offer(new int[] {Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])});
		}
			
		int result = 0;
		
		while(!q.isEmpty()){
			int[] curr = q.poll();
			
			if(find(curr[0],p)== find(curr[1],p)) continue;
			
			result += curr[2];
			
			union(curr[0], curr[1], p);
			
		}

		System.out.println(result);
	}
	
	public static void union(int a, int b, int[] p) {
		a = find(a,p);
		b = find(b,p);
		if(a<b) p[b] = a;
		else p[a] = b;
	}
	
	public static int find(int x, int[] p) {
		if(p[x] == x) return x;
		return p[x] = find(p[x], p);
	}

}
