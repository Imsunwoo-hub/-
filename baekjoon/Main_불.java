package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_불 {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int R = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		
		char[][] map = new char[R][C];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
			
		});
		
		Queue<int[]> fires = new LinkedList<>();
		int[][] v = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String t= br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j]=='J') {
					q.offer(new int[] {i,j,0});
					v[i][j] = 1;
					map[i][j] = '.';
				}
				if(map[i][j]=='F') fires.offer(new int[] {i,j});
			}
		}
		
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		
		
		while(true) {
			
			int size = fires.size();
			
			for(int i=0; i<size; i++) {
				int[] fire = fires.poll();
				for(int d=0; d<4; d++) {
					int ni = fire[0]+di[d];
					int nj = fire[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<R && nj<C && (map[ni][nj] == '.' || map[ni][nj]=='J')) {
						map[ni][nj] ='F';
						fires.offer(new int[] {ni,nj});
					}
				}
			}
			
			size= q.size();
			for(int i=0; i<size; i++) {
				int[] curr = q.poll();
				
				
				if(curr[0]==0 || curr[1]==0 || curr[0]== R-1 || curr[1]==C-1) {
					System.out.println(curr[2]+1);
					return;
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj]=='.' && v[ni][nj]==0) {
						v[ni][nj] = 1;
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
			if(q.isEmpty()) break;
			
			
		}
		
		System.out.println("IMPOSSIBLE");
		
	}

}
