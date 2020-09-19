package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_체스판다시칠하기 {
	
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] map = new char[N][M];
		char[][] B = new char[8][8];
		char[][] W = new char[8][8];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
			}
		}
		
		drow('B', B);
		drow('W', W);
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				result = Math.min(result, Math.min(count(i,j,B,map), count(i,j,W,map)));
			}
		}
		
		System.out.println(result);

	}
	
	
	public static void drow(char c, char[][] m) {
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int[][] v = new int[m.length][m[0].length];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,c-'0'});
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				m[curr[0]][curr[1]] = (char)(curr[2]+'0');
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					
					if(ni>=0 && ni<m.length && nj>=0 && nj<m[0].length && v[ni][nj]==0) {
						if(curr[2]=='W'-'0') {
							q.offer(new int[] {ni,nj,'B'-'0'});
						}
						else {
							q.offer(new int[] {ni,nj,'W'-'0'});
						}
					}
				}
				
			}
		}
	}
	
	public static int count(int a, int b, char[][] cmap , char[][] map) {
		int count = 0;
		
		for(int i=a; i<a+8; i++) {
			for(int j=b; j<b+8; j++) {
				if(cmap[i-a][j-b]!=map[i][j]) count++;
			}
		}
		
		return count;
	}

}
