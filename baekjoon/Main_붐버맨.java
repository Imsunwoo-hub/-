package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_붐버맨 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int R = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		int N = Integer.parseInt(s[2]);
		
		char[][] map = new char[R][C];
		int[][] v = new int[R][C];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for(int i=0; i<R; i++) {
			String t = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j]=='O') {
					v[i][j] = 3;
					q.offer(new int[] {i,j,3});
				}
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		int time = 0;
		
		while(time<N) {
			time++;
			if(time%2==0) {
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j]=='.') {
							map[i][j] = 'O';
							v[i][j] = time+3;
							q.offer(new int[] {i,j,time+3});
						}
					}
				}
			}
			
			if(time!=1 && time%2==1) {
				while(true) {
					if(q.isEmpty() || q.peek()[2]>time) break;
					int[] curr = q.poll();
					
					if(v[curr[0]][curr[1]]!=curr[2]) continue;
					map[curr[0]][curr[1]] = '.';
					v[curr[0]][curr[1]] = 0;
					for(int d=0; d<4; d++) {
						int ni = curr[0] + di[d];
						int nj = curr[1] + dj[d];
						if(ni>=0 && nj>=0 && ni<R && nj<C) {
							map[ni][nj] = '.';
							if(v[ni][nj]!=curr[2]) v[ni][nj] = 0;
						}
					}
				}
			}
//			System.out.println(time);
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("----------------");
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(v[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("----------------");
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
