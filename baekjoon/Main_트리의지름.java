package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_트리의지름 {
	
	static int N, end, result, v[];
	static ArrayList<int[]>[] list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[10001];
		
		for(int i=1; i<=10000; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		end = 0;
		result = 0;
		v = new int[10001];
		dfs(1,0);
	
		result = 0;
		v = new int[10001];
		dfs(end,0);
		
		System.out.println(result);

	}
	
	public static void dfs(int i, int temp) {
		v[i] = 1;
		if(temp > result) {
			result = temp;
			end = i;
		}
		for(int j=0; j<list[i].size(); j++) {
			int curr[] = list[i].get(j);
			if(v[curr[0]]==0) {
				dfs(curr[0], temp+curr[1]);
			}
		}
		
	}

}
