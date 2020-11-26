package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_다리만들기 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N;

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		int[][] v = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int idx = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && v[i][j]==0) {
					dfs(i,j,map,v,idx);
					idx++;
				}
			}
		}
		
	
		int result = Integer.MAX_VALUE;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[2], arg1[2]);
			}
		});
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {
					int temp = 0;
					q.clear();
					v = new int[N][N];
					for(int d=0; d<4; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]==0 && v[ni][nj]==0) {
							v[ni][nj] = 1;
							q.offer(new int[] {ni,nj, 1, map[i][j]});
						}
					}
					while(!q.isEmpty()) {
						int curr[] = q.poll();
						if(map[curr[0]][curr[1]] != 0 && map[curr[0]][curr[1]] != curr[3]) {
							temp = curr[2];
							break;
						}
						
						for(int d=0; d<4; d++) {
							int ni = curr[0]+di[d];
							int nj = curr[1]+dj[d];
							if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj] != curr[3] && v[ni][nj]==0) {
								v[ni][nj] = 1;
								if(map[ni][nj]==0) {
									q.offer(new int[] {ni,nj, curr[2]+1, curr[3]});
								}
								else {
									q.offer(new int[] {ni,nj, curr[2], curr[3]});
								}
							}
						}
					}
					if(temp != 0 && temp < result) result = temp;
				}
			}
		}
		
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int j, int[][] map, int[][] v, int idx) {
		v[i][j] = 1;
		map[i][j] = idx;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]==1 && v[ni][nj]==0) {
				dfs(ni,nj,map,v,idx);
			}
		}
	}

}
