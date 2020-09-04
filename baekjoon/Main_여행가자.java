package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_여행가자 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		int N = Integer.parseInt( br.readLine());
		int M = Integer.parseInt( br.readLine());
		
		int[] p = new int[N];
		
		for(int i=0; i<N; i++) p[i] = i;
		
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<s.length; j++) {
				if(s[j].equals("1")) union(i,j,p);
			}
		}
		String[] s = br.readLine().split(" ");
		
		int before = p[Integer.parseInt(s[0])-1];
		
		for(int i=1; i<s.length; i++) {
			int a = Integer.parseInt(s[i])-1;
			if(p[a]!=before) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");

	}
	
	public static void union(int a, int b, int[] p) {
		a = find(a,p);
		b = find(b,p);
		if(a<=b) p[b] = a;
		else p[a] = b;
	}
	
	public static int find(int x, int[] p) {
		if(p[x]==x) return x;
		return p[x] = find(p[x],p);
	}

}
