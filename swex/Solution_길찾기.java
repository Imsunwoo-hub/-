package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_길찾기 {
	
	public static int V = 100;
	public static int T;
	public static int N;
	public static int[][] graph;
	public static boolean[] visit;
	//public static Stack<Integer> stack;
	

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			String line=br.readLine();
			String[] s = line.split(" ");
			T = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			
			graph = new int[V][V];
			
			int[] temp = new int[N*2];
			
			line = br.readLine();
			s = line.split(" ");
			for(int i=0; i<N*2; i+=2) {
				int c1 = Integer.parseInt(s[i]);
				
				int c2 = Integer.parseInt(s[i+1]);
				
				graph[c1][c2] = 1; 
			}
	
			visit = new boolean[V];
			System.out.println("#" + T+" " + dfsr(0));
		}
	}
	
	public static int dfsr(int node) {
		visit[node] = true;
		if(node==99) return 1;
		
		for(int next=0; next<V; next++)
			{
				if(visit[next]==false && graph[node][next]==1) {
					if(dfsr(next)==1) return 1;
				}
			}
		return 0;
		
	}

}
