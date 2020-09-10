package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_벽부수고이동하기4 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][] imap = new int[N][M];
		int[][] v = new int[N][M];
		int[][] result = new int[N][M];
		
		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		HashMap<Integer,Integer> hm = new HashMap<>(); 
		Set<Integer> set = new HashSet<>();
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j)-'0';
				if(map[i][j]==1) list.add(new int[] {i,j}); 
			}
		}
		
		int idx = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0 && v[i][j]==0) {
					int cnt = 0;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						if(v[curr[0]][curr[1]]==0) {
							v[curr[0]][curr[1]]=1;
							cnt++;
							imap[curr[0]][curr[1]] = idx;
							
							for(int d=0; d<4; d++) {
								int ni = curr[0]+di[d];
								int nj = curr[1]+dj[d];
								
								if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0 && v[ni][nj]==0) {
									q.offer(new int[] {ni,nj});
								}
							}
						}
					}
					hm.put(idx, cnt);
					idx++;
				}
			}
		}
		
		
		for(int[] l:list) {
			set.clear();
			for(int d=0; d<4; d++) {
				int ni = l[0]+di[d];
				int nj = l[1]+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0 ) {
					set.add(imap[ni][nj]);
				}
			}
			for(int i:set ) result[l[0]][l[1]] += hm.get(i) ;
			result[l[0]][l[1]]++;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(result[i][j]%10);
			}
			System.out.println();
		}
		
	}

}
