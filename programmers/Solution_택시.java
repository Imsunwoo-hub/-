package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_택시 {
	
	public static int solution (int n, int s, int a, int b, int[][] f) {
		int answer = Integer.MAX_VALUE;
		int[][] gp = new int[n+1][n+1];
		
		for(int i=0; i<f.length; i++) {
			int c = f[i][0];
			int d = f[i][1];
			int x = f[i][2];
			gp[c][d] = x;
			gp[d][c] = x;
		}
		
		int[] ad = new int[n+1];
		int[] bd = new int[n+1];
		int[] sd = new int[n+1];
		int inf = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			ad[i] = inf;
			bd[i] = inf;
			sd[i] = inf;
		}
		
		solve(a,n,ad,gp);
		solve(b,n,bd,gp);
		solve(s,n,sd,gp);
		
		for(int i=1; i<=n; i++) {
			answer = Math.min(answer, ad[i]+bd[i]+sd[i]);
		}
		
		return answer;
	}
	
	public static void solve(int s, int n, int[] d, int[][] gp) {
		d[s] = 0;
		int[] v = new int[n+1];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		q.offer(new int[] {s,d[s]});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); 
			
			if(v[curr[0]]==0){
				v[curr[0]] = 1;
				
				for(int i=1; i<=n; i++) {
					if(gp[i][curr[0]]==0) continue;
					if(d[i] > d[curr[0]]+gp[i][curr[0]]) {
						d[i] = d[curr[0]]+gp[i][curr[0]];
						q.offer(new int[] {i,d[i]});
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		System.out.println(solution(6,4,6,2,new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
		System.out.println(solution(7,3,4,1,new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
		System.out.println(solution(6,4,5,6,new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));

	}

}
