package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_구슬탈출2 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] ridx, bidx, oidx;
	static int result, bol, N, M;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		char[][] ca = new char[N][M];

		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				ca[i][j] = t.charAt(j);
			}
		}
		result = -1;
		bol = 0;
		dfs(0, -1, ca);
		System.out.println(result);
	}
	
	static void dfs(int c, int d, char[][] ca) {
		if(c>10) return;
		char[][] tca = new char[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tca[i][j] = ca[i][j];
			}
		}
		if(d!=-1) {
			move(d, tca);
			//for(char[] a:tca) System.out.println(Arrays.toString(a));
			//System.out.println();
			
			if(bol==1) {
				if(result == -1) result =c;
				else {
					if(result > c) result = c;
				}
			}
			bol = 0; 
		}
		for(int i=0; i<4; i++) {
			dfs(c+1, i, tca);
		}
	}
	
	static void move(int d, char[][] tca) {
		PriorityQueue<int[]> q;
		if(d==0) {
			q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
		}
		else if(d==1) {
			q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return -Integer.compare(o1[0], o2[0]);
				}
			});
		}
		else if(d==2) {
			q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[1], o2[1]);
				}
			});
			
		}
		else {
			q = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return -Integer.compare(o1[1], o2[1]);
				}
			});
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tca[i][j]=='R') q.offer(new int[] {i,j});
				if(tca[i][j]=='B') q.offer(new int[] {i,j});
			}
		}
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			
			int ni = curr[0]+di[d];
			int nj = curr[1]+dj[d];
			
			if(tca[ni][nj] == '.') {
				tca[ni][nj] = tca[curr[0]][curr[1]];
				tca[curr[0]][curr[1]] = '.';
				q.offer(new int[] {ni,nj});
				
			}
			else if(tca[ni][nj] == 'O') {
				tca[curr[0]][curr[1]] = '.';
			}
		}
		
		
		int rc = 0;
		int bc = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tca[i][j]=='R') rc++;
				if(tca[i][j]=='B') bc++;
			}
		}
	
		if(rc==0 && bc != 0) {
			bol = 1;
		}
		
	}

}
