package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_친구비 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		int[] p = new int[N+1];
		
		for(int i=1; i<=N; i++) p[i] = i;
		
		s = br.readLine().split(" ");
		int[] ka = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			ka[i] = Integer.parseInt(s[i-1]);
		}
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int v = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			union(v,w,p,ka);
		}
		
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			int a = find(i,p);
			sum += ka[a];
			ka[a] = 0;
		}
		
		if(sum > K) System.out.println("Oh no");
		else System.out.println(sum);
		
	}
	
	
	public static void union(int a, int b, int[] p, int[] ka) {
		a = find(a,p);
		b = find(b,p);
		if(ka[a]<=ka[b]) p[b] = a;
		else p[a] = b;
	}
	
	public static int find(int x, int[] p) {
		if(p[x]==x) return x;
		return p[x] = find(p[x], p);
	}

}
