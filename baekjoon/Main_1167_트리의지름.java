package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1167_트리의지름 {
	
	static int N, end, len;
	static int[] v;
	static ArrayList<int[]>[] list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		v = new int[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			for(int j=1; j<s.length-1; j+=2) {
				int v = Integer.parseInt(s[j]);
				int e = Integer.parseInt(s[j+1]);
				list[a].add(new int[] {v, e});
			}
		}
		
		
		end = 0;
		len = 0;
		dfs(1,0);
		len = 0;
		v = new int[N+1];
		dfs(end,0);
		System.out.println(len);
		
	}
	
	public static void dfs(int i, int sum) {
		v[i] = 1;
		if(sum > len) {
			len = sum;
			end = i;
		}
		
		for(int[] curr : list[i]) {
			if(v[curr[0]]==0) {
				dfs(curr[0], sum+curr[1]);
			}
		}
	}

}
