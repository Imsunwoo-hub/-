package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_중립국2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
	
		int[] p = new int[N+1];
		int[] v = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			union(a,b,p);
		}
		
		//System.out.println(Arrays.toString(p));
		
		int C = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0; i<C; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			v[find(a,p)] = b;
			
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(v[find(i,p)]+" ");
		}
	}
	
	
	public static void union(int a, int b, int[] p) {
		a = find(a, p);
		b = find(b, p);
		if(a<b) p[b] = a;
		else p[a] = b;
	}
	
	public static int find(int x, int[] p) {
		if(p[x] == x) return x;
		return p[x] = find(p[x], p);
	}

}
