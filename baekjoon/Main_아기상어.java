package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_아기상어 {
	
	static int result, N, lv, count; 
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] shack;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		N = Integer.parseInt(s);
		int[][] map = new int[N][N];
		shack = new int[3];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
				if(map[i][j]==9) {
					shack[0] = i;
					shack[1] = j;
					shack[2] = 0;
					map[i][j] = 0;
				}
			}
		}
		result = 0;
		lv = 2;
		count = 0;
		while(true) {
			int bol = bfs(map);
			if(bol == 0)break;
			else result += bol;
		}
		System.out.println(result);
	}
	
	
	static int bfs(int[][] map) {
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[2], o2[2]);
				if(r==0) r = Integer.compare(o1[0], o2[0]);
				if(r==0) r = Integer.compare(o1[1], o2[1]);
				return r;
			}
		});
		
		int[][] v = new int[N][N];
		q.offer(shack);
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				
				if( map[curr[0]][curr[1]] != 0 && map[curr[0]][curr[1]] < lv) {
					count++;
					if(count == lv) {
						lv++;
						count = 0;
					}
					map[curr[0]][curr[1]] = 0;
					shack[0] = curr[0];
					shack[1] = curr[1];
					shack[2] = 0;
 					return curr[2];
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0 && map[ni][nj]<=lv) {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
		}
		
		
		return 0;
	}

}
