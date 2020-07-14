package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_다리만들기2 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N,M;
	static int[][] ia, v;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		ia = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
			}
		}
		v =  new int[N][M];
		int c = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(ia[i][j]==1 && v[i][j]==0) {
					v[i][j] = 1;
					ia[i][j] = c;
					dfs(i,j,c);
					c++;
				}
			}
		}
		
		int[] p = new int[c];
		for(int i=1; i<c; i++) {
			p[i] = i;
		}
		
		int[][] gp = new int[c][c];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++) {
				if(ia[i][j] != 0) {
					int cnt = 0;
					for(int k=i; k>=0; k--) {
						if(ia[k][j]==0) cnt++;
						if(ia[k][j] == ia[i][j]) cnt= 0;
						else if((ia[k][j] != 0 && ia[k][j] != ia[i][j])  ) {
							if(gp[ia[i][j]][ia[k][j]]==0 && cnt>=2) {
								gp[ia[i][j]][ia[k][j]]=cnt;
								gp[ia[k][j]][ia[i][j]]=cnt;
							}
							else {
								if(gp[ia[i][j]][ia[k][j]]>cnt && cnt>=2) {
									gp[ia[i][j]][ia[k][j]]=cnt;
									gp[ia[k][j]][ia[i][j]]=cnt;
								}
							}
							break;
						}
					}
					cnt = 0;
					for(int k=i; k<N; k++) {
						if(ia[k][j]==0) cnt++;
						if(ia[k][j] == ia[i][j]) cnt = 0;
						else if((ia[k][j] != 0 && ia[k][j] != ia[i][j])) {
							if(gp[ia[i][j]][ia[k][j]]==0  && cnt>=2 ) {
								gp[ia[i][j]][ia[k][j]]=cnt;
								gp[ia[k][j]][ia[i][j]]=cnt;
							}
							else {
								if(gp[ia[i][j]][ia[k][j]]>cnt  && cnt>=2 ) {
									gp[ia[i][j]][ia[k][j]]=cnt;
									gp[ia[k][j]][ia[i][j]]=cnt;
								}
							}
							break;
						}
					}
					cnt = 0;
					for(int k=j; k<M; k++) {
						if(ia[i][k]==0) cnt++;
						if(ia[i][k] == ia[i][j]) cnt=0;
						else if((ia[i][k] != 0 && ia[i][k] != ia[i][j]) ) {
							if(gp[ia[i][j]][ia[i][k]]==0 && cnt>=2 ) {
								gp[ia[i][j]][ia[i][k]]=cnt;
								gp[ia[i][k]][ia[i][j]]=cnt;
								
							}
							else {
								if(gp[ia[i][j]][ia[i][k]]>cnt && cnt>=2 ) {
									gp[ia[i][j]][ia[i][k]]=cnt;
									gp[ia[i][k]][ia[i][j]]=cnt;
								}
							}
							break;
						}
					}
					cnt = 0;
					for(int k=j; k>=0; k--) {
						if(ia[i][k]==0) cnt++;
						if(ia[i][k] == ia[i][j]) cnt=0;
						else if((ia[i][k] != 0 && ia[i][k] != ia[i][j])  ) {
							if(gp[ia[i][j]][ia[i][k]]==0 && cnt>=2) {
								gp[ia[i][j]][ia[i][k]]=cnt;
								gp[ia[i][k]][ia[i][j]]=cnt;
								
							}
							else {
								if(gp[ia[i][j]][ia[i][k]]>cnt && cnt>=2) {
									gp[ia[i][j]][ia[i][k]]=cnt;
									gp[ia[i][k]][ia[i][j]]=cnt;
								}
							}
							break;
						}
					}
				}
			}
		}
		//for(int[] g:gp)System.out.println(Arrays.toString(g));
		//System.out.println();
		//for(int[] a:ia)System.out.println(Arrays.toString(a));
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int i=1; i<c; i++) {
			for(int j=1; j<c; j++) {
				if(gp[i][j] > 0) {
					q.offer(new int[] {i,j,gp[i][j]});
				}
			}
		}
		int result = 0;
		int bol = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			//System.out.println(curr[0]+", "+curr[1]+", "+curr[2]);
			if(find(p,curr[0])==find(p,curr[1])) continue;
			union(p,curr[0],curr[1]);
			bol++;
			result += curr[2];
		}
//		int ena = 0;
//		for(int i=1; i<p.length-1; i++) {
//			if(p[i]!=p[i+1]) ena = 1;
//		}
		if(bol< c-2 ) result = -1;
		//System.out.println(Arrays.toString(p));
		System.out.println(result);

	}
	
	public static void union(int[] p, int x, int y) {
		int a = find(p, x);
		int b = find(p, y);
		if(a<b) p[a] = b;
		else p[b] = a;
	}
	
	public static int find(int[] p, int x) {
		if(p[x]==x) return x;
		return p[x] = find(p, p[x]);
	}
	
	public static void dfs(int i, int j, int c) {
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj] ==0 && ia[ni][nj]!=0) {
				v[ni][nj] = 1;
				ia[ni][nj] = c;
				dfs(ni,nj,c);
			}
		}
		
	}

}
