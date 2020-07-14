package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_치킨배달 {
	
	static int N,M, result, tres;
	static int[][] map, data, temp, v;
	static ArrayList<int[]> hlist;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][N];
		
		ArrayList<int[]> list = new ArrayList<>();
		hlist = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String[] t= br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
				if(map[i][j]==2) {
					list.add(new int[] {i,j});
				}
				if(map[i][j]==1) {
					hlist.add(new int[] {i,j});
				}
				
			}
		}
		int idx = 0;
		data = new int[list.size()][2];
		temp = new int[M][2];
		for(int[] l:list) data[idx++] = l; 
		result = Integer.MAX_VALUE;
		comb(data.length, M);
		
		System.out.println(result);
	}
	
	static void comb(int n, int c) {
		if(n<c) return;
		if(c==0) {
			
			int sum =0;
			for(int[] h:hlist) {
				
				int w = Integer.MAX_VALUE;
				for(int[] t:temp) {
					
					int tw = Math.abs(h[0]-t[0]) + Math.abs(h[1]-t[1]);
					if(w>tw) w=tw;
					
				}
				sum += w;
				
			}
			if(result > sum) result = sum;
			return;
		}
		temp[c-1] = data[n-1];
		comb(n-1,c-1);
		comb(n-1,c);
	}

}
