package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_5427_불 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Queue<int[]> man = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		Queue<int[]> fire =  new LinkedList<>();
		
		for(int tc=1; tc<=T; tc++) {
			
			int bol = 0;
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[1]);
			int M = Integer.parseInt(s[0]);
			
			char[][] map = new char[N][M];
			int[][] v = new int[N][M];
			man.clear();
			fire.clear();
			
			for(int i=0; i<N; i++) {
				String t = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] = t.charAt(j);
					if(map[i][j]=='@') {
						map[i][j] = '.';
						v[i][j] = 1;
						man.offer(new int[] {i,j,0});
					}
					if(map[i][j]=='*') fire.offer(new int[] {i,j});
				}
				
			}
			
			int[] di = {-1,1,0,0};
			int[] dj = {0,0,-1,1};
			
			while(!man.isEmpty()) {
				
				int size = fire.size();
				for(int i=0; i<size; i++) {
					int[] curr = fire.poll();
					for(int d=0; d<4; d++) {
						int ni = curr[0]+di[d];
						int nj = curr[1]+dj[d];
						if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj] == '.') {
							map[ni][nj] = '*';
							fire.offer(new int[] {ni,nj});
						}
					}	
				}
				
				size = man.size();
				for(int i=0; i<size; i++) {
					int curr[] = man.poll();
					
					if(curr[0] == 0 || curr[1] == 0 || curr[0] == N-1 || curr[1] == M-1 ) {
						System.out.println(curr[2]+1);
						bol = 1;
						man.clear();
						break;
					}
					
					for(int d=0; d<4; d++) {
						int ni = curr[0]+di[d];
						int nj = curr[1]+dj[d];
						if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]=='.' && v[ni][nj] == 0) {
							v[ni][nj] = 1;
							man.offer(new int[] {ni,nj,curr[2]+1});
						}
					}
				}
			}
			
			if(bol == 0) System.out.println("IMPOSSIBLE");
		}
	}

}
