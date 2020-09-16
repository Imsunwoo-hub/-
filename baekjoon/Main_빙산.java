package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_빙산 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] != 0) q.offer(new int[] {i,j});
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int result = 0;
		int[][] cmap = new int[N][M];
		int time = 0;
		while(!q.isEmpty()) {
			time++;
			copy(map,cmap);
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] curr = q.poll();
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0) {
						cnt++;
					}
				}
				if(map[curr[0]][curr[1]]-cnt <= 0) {
					cmap[curr[0]][curr[1]] = 0;
				}
				else {
					cmap[curr[0]][curr[1]] = map[curr[0]][curr[1]]-cnt;
					q.offer(new int[] {curr[0],curr[1]});
				}
			}
			copy(cmap,map);
			int cnt = 0;
			int[][] v = new int[N][M];
			size = q.size();
			for(int i=0; i<size; i++) {
				int[] curr = q.poll();
				if(v[curr[0]][curr[1]]==0) {
					cnt++;
					dfs(curr[0],curr[1],v,map,di,dj);
				}
				q.offer(new int[] {curr[0],curr[1]});
			}
			
			if(cnt>=2) {
				result = time;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void dfs(int i, int j, int[][] v, int[][] map, int[] di, int[] dj) {
		v[i][j] = 1;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<map.length && nj<map[0].length && map[ni][nj]!=0 && v[ni][nj] ==0) {
				dfs(ni,nj,v,map,di,dj);
			}
		}
	}
	
	public static void copy(int[][] o, int[][] c) {
		for(int i=0; i<o.length; i++) {
			for(int j=0; j<o[0].length; j++) {
				c[i][j] = o[i][j];
			}
		}
	}

}
