package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_불켜기 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		ArrayList<int[]>[][] list = new ArrayList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
		int[][] v = new int[N][N];
		int[][] on = new int[N][N];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int x =Integer.parseInt(s[0])-1;
			int y =Integer.parseInt(s[1])-1;
			int a =Integer.parseInt(s[2])-1;
			int b =Integer.parseInt(s[3])-1;
			list[x][y].add(new int[] {a,b});
		}
		
		on[0][0] = 1;
		v[0][0] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		
		int result = 1;
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			
			for(int[]  l: list[curr[0]][curr[1]]) {
				if(on[l[0]][l[1]]==0) {
					result ++;
					on[l[0]][l[1]] = 1;
					for(int d=0; d<4; d++) {
						int ni = l[0]+di[d];
						int nj = l[1]+dj[d];
						if(ni>=0 && nj>=0 && ni<N && nj<N && on[ni][nj]==1 && v[ni][nj]==1) q.offer(new int[] {ni, nj});
					}
				}
			}
			
			
			for(int d=0; d<4; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				
				if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0 && on[ni][nj]==1) {
					v[ni][nj] =1;
					q.offer( new int[] {ni, nj});
				}
			}
		}
		
		
		System.out.println(result);
		
	}

}
