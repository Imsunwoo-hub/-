package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_연구소 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};;
	static int max, ia[][], tia[][], N,M;
	static ArrayList<int[]> clist;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ia = new int[N][M];
		tia = new int[N][M];
		//ArrayList<int[]> list = new ArrayList<>();
		clist = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ia[i][j] = sc.nextInt();
				if(ia[i][j]==0) clist.add(new int[] {i,j});
			}
		}
		
		max = 0;
		dfs(0,0);
		System.out.println(max);

	}
	
	
	
	
	static void dfs(int i,int c) {
		if(c==3) {
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					tia[a][b] = ia[a][b];
				}
			}
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(tia[a][b]== 2 ) dfs2(a,b);
				}
			}
			int tempc = 0;  
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(tia[a][b]==0) tempc++;
				}  
			}  
			
			if(tempc > max) max = tempc;
			return;
		}
		if(i==clist.size() || c>3) return;
		
		ia[clist.get(i)[0]][clist.get(i)[1]] = 1;
		dfs(i+1, c+1);
		ia[clist.get(i)[0]][clist.get(i)[1]] = 0;
		dfs(i+1, c);
		
	}
	
	static void dfs2(int i, int j) {
		
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj <M && tia[ni][nj] == 0 ) {
				tia[ni][nj] = 2;
				dfs2(ni,nj);
			}
		}
		
	}

}
