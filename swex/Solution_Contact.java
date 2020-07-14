package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_Contact {
	
	
	public static int[][] graph,visit ;
	public static int cal[], result[];

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int start = Integer.parseInt(s[1]);
			visit = new int[101][101];
			result = new int[101];
			graph = new int[101][101];
			cal  = new int[101];
			String[] t = br.readLine().split(" ");
			for(int i=1; i<t.length; i+=2) {
				int v1 = Integer.parseInt(t[i-1]);
				int v2 = Integer.parseInt(t[i]);
				graph[v1][v2] = 1;
			}
			
			dfs(start,0);
			int max = 0;
			int r = 0;
			for(int i = 0; i<result.length; i++) {
				if(result[i]>=max) {
					max = result[i];
					r = i;
				}
			}
			System.out.println("#"+tc+" "+r);
		}
	}
	
	public static void dfs(int i, int count) {
		cal[i] = 1;
		for(int j=1; j<101; j++) {
			if(graph[i][j] == 1 && cal[j] == 0) {
				//System.out.print(i+" ");
				dfs(j,count+1);
			} 
		}
		result[i] = count;
		
	}
}

