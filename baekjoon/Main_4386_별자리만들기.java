package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_4386_별자리만들기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] p = new int[N];
		
		for(int i=0; i<N; i++) p[i] = i;
		
		double[][] di = new double[N][2];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			di[i][0] = Double.parseDouble(s[0]);
			di[i][1] = Double.parseDouble(s[1]);
		}
		
		PriorityQueue<double[]> q = new PriorityQueue<>(new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				double d = Math.sqrt((di[i][0] - di[j][0])* (di[i][0] - di[j][0]) +  (di[i][1] - di[j][1])* (di[i][1] - di[j][1]));
				q.offer(new double[] {i,j,d});
			}
		}
		double result = 0;
		while(!q.isEmpty()) {
			double[] curr = q.poll();
			int a = (int)curr[0];
			int b = (int)curr[1];
			if(find(a,p)==find(b,p)) continue;
			result += curr[2];
			union(a,b,p);
			
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
		if(p[x]==x) return x;
		return p[x] = find(p[x],p);
	}

}
