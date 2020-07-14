package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_사다리조작 {
	
	static int N,M,H,result;
	static int[][] ia;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]);
		
		ia = new int[H][N];
		
		for(int i=0; i<M; i++) {
			String[] t = br.readLine().split(" ");
			int a = Integer.parseInt(t[0])-1;
			int b = Integer.parseInt(t[1])-1;
			ia[a][b] = 1;
			ia[a][b+1] = 2;
		} 
		
		result = -1;
		for(int i=0; i<=3; i++) {
			dfs(i,0,0);
			if(result != -1) break;
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int end, int idx, int cnt) {
		if(result != -1) return;
		if(end==cnt) {
			//for(int[] a: ia) System.out.println(Arrays.toString(a));
			//System.out.println();
			int bol = 0;
			for(int j=0; j<N; j++ ) {
				int start = j;
				int i = 0;
				while(true) {
					if(ia[i][start]==1) start+=1;
					else if(ia[i][start]==2) start-=1;
					i++;
					if(i==H) {
						if(start != j) bol = 1;
						break;
					}
				}
				if(bol == 1) break;
			}
			if(bol==0) result = end;
			return;
		}
		
		for(int i=idx; i<H; i++) {
			for(int j=0; j<N-1; j++) {
				if(ia[i][j]==0 && ia[i][j+1] ==0) {
					ia[i][j] = 1;
					ia[i][j+1] = 2;
					dfs(end, i, cnt+1);
					ia[i][j] = 0;
					ia[i][j+1] = 0;
				}
			}
		}
		
	}
	
	

}
