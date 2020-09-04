package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_집합의표현 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=  br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] p = new int[N+1];
		
		for(int i=0; i<=N; i++) p[i] = i;
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int w = Integer.parseInt(s[0]);
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			if(w==0) union(a,b,p);
			else {
				if(find(a,p)==find(b,p)) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}
		
	}
	
	public static void union(int a, int b, int[] p) {
		a = find(a, p);
		b = find(b, p);
		
		if(a<=b) p[b] = a;
		else p[a] = b;
	}
	
	public static int find(int x, int[] p) {
		if(p[x]==x) return x;
		return p[x] = find(p[x], p);
	}

}
