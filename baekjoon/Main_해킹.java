package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_해킹 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int K = Integer.parseInt(s[2]);
			
			ArrayList<int[]>[] list = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				int t = Integer.parseInt(s[2]);
				list[b].add(new int[] {a,t});
			}
			
			int[] d = new int[N+1];
			int[] v = new int[N+1];
			int inf = 10001*1000;
			for(int i=1; i<=N; i++) {
				d[i] = inf;
			}
			d[K] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1[1], o2[1]);
				}
			});
			
			q.offer(new int[] {K,0});
			
			while(!q.isEmpty()) {
				int curr[] = q.poll();
				
				if(v[curr[0]]==1) continue;
				v[curr[0]] = 1;
				
				for(int[] l:list[curr[0]]) {
					if(d[l[0]] > d[curr[0]]+l[1]) {
						d[l[0]] = d[curr[0]]+l[1];
						q.offer(new int[] {l[0], d[l[0]]});
					}
				}
			}
			
			int cnt = 0;
			int max = 0;
			for(int i=1; i<=N; i++) {
				if(d[i]!=inf) {
					cnt++;
					if(d[i]>max) max = d[i];
				}
			}
			System.out.println(cnt+" "+max);
		}

	}

}
