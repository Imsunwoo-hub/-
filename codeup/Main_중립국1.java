package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_중립국1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] ia = new int[N+1];
		for(int i=0; i<=N; i++) {
			ia[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			union(a,b, ia);
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(find(ia[i],ia)+" ");
		}
		System.out.println();
	}
	
	public static void union(int a, int b, int[] ia) {
		a = find(a, ia);
		b = find(b, ia);
		if(a<b) {
			ia[b] = a;
			
		}
		else {
			ia[a] = b;
		}
	}
	
	public static int find(int x, int[] ia) {
		if(ia[x]==x) return x;
		return ia[x] = find(ia[x], ia);
	}

}
