package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_이분그래프 {
	
	static int[] v;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			
			tree = new ArrayList[V+1];
			v = new int[V+1];
			
			for(int i=1; i<=V; i++) tree[i] = new ArrayList<>();
			
			for(int i=0; i<E; i++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				tree[a].add(b);
				tree[b].add(a);
			}
			
			for(int i=1; i<=V; i++) {
				if(v[i]==0) {
					dfs(i,1);
				}
			}
			
			
			int bol = 0;
			for(int i=1; i<=V; i++) {
				for(int j=0; j<tree[i].size(); j++) {
					int k = tree[i].get(j);
					if(v[i]==v[k]) {
						bol = 1;
						break;
					}
				}
				if(bol==1) break;
			}
			if(bol==0) System.out.println("YES");
			else System.out.println("No");
		}

	}
	
	public static void dfs(int i, int c) {
		v[i] = c;
		for(int j=0; j<tree[i].size(); j++) {
			int ni = tree[i].get(j);
			if(v[ni] == 0) {
				dfs(ni, 3-c);
			}
		}
	}

}
