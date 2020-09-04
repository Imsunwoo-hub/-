package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_친구네트워크 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] p = new int[200000+1];
			int[] pCnt = new int[200000+1];
			int idx = 1;
			
			for(int i=1; i<=200000; i++) {
				p[i] = i;
				pCnt[i] = 1;
			}
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				if(!map.containsKey(s[0])) map.put(s[0], idx++);
				if(!map.containsKey(s[1])) map.put(s[1], idx++);
		
				int a = map.get(s[0]);
				int b = map.get(s[1]);
				
				union(a,b,p,pCnt);
			}
			
		}
		
	}
	
	public static void union(int a, int b, int[] p, int[] pCnt) {
		a = find(a,p);
		b = find(b,p);
		if(a==b) {
			System.out.println(pCnt[a]);
			return;
		}
		if(a<b) {
			p[b] = a;
			pCnt[a] += pCnt[b];
			System.out.println(pCnt[a]);
		}
		else {
			p[a] = b;
			pCnt[b] += pCnt[a];
			System.out.println(pCnt[b]);
		}
		
	}
	
	public static int find(int x, int[] p) {
		if(p[x]==x) return x;
		return p[x] = find(p[x],p);
	}

}
