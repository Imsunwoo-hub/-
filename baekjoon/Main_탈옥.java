package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_탈옥 {
	
	static int N, M;
	static int[][] cmap;
	static char[][] map;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] s = br.readLine().split(" ");
			
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			map = new char[N+2][M+2];
			
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<M+2; j++) {
					map[i][j] = '.';
				}
			}
			list = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				String t = br.readLine();
				for(int j=1; j<=M; j++) {
					map[i][j] = t.charAt(j-1);
					if(map[i][j]=='$') list.add(new int[] {i,j});
				}
			}
			list.add(new int[] {0,0});
			int[][] cmap = new int[N+2][M+2];
			for(int[] l:list) {
				int[][] tmap = bfs(l[0], l[1]);
				
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<M+2; j++) {
						cmap[i][j] += tmap[i][j]; 
					}
				}
				
 			}
			
			int result = Integer.MAX_VALUE;
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<M+2; j++) {
					if(map[i][j]=='*')continue;
 					if(map[i][j]=='#' ) {
						cmap[i][j] -= 2;						
					}
 					if(result > cmap[i][j]) result = cmap[i][j];
				}
			}
			System.out.println(result);
		}
	}
	
	public static int[][] bfs(int i, int j){
		int[][] tmap = new int[N+2][M+2];
		int[][] v = new int[N+2][M+2];
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		q.offer(new int[] {i,j,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				tmap[curr[0]][curr[1]] = curr[2];
				
			
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N+2 && nj<M+2 && v[ni][nj]==0 && map[ni][nj]!='*') {
						if(map[ni][nj]=='#') {
							q.offer(new int[] {ni,nj,curr[2]+1});
						}
						else {
							q.offer(new int[] {ni,nj,curr[2]});
						}
					}
				}
			}
			
		}
		
		return tmap;
		
	}

}
