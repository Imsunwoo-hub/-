package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1600_말이되고픈원숭이 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][][] v = new int[N][M][3];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[3],o2[3]);
			}
		});
		
		q.offer(new int[] {0,0,K,0});
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int[] mali = {-2, -1, -2, -1, 1, 2, 1,  2};
		int[] malj = {-1, -2,  1,  2, 2, 1,-2, -1};
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==N-1 && curr[1] == M-1) {
				System.out.println(curr[3]);
				return;
			}
			
			if(curr[2] > 0) {
				for(int d=0; d<mali.length; d++) {
					int ni = curr[0]+mali[d];
					int nj = curr[1]+malj[d];
					if(ni >=0 && nj >=0 && ni<N && nj<M && map[ni][nj] != 1 && v[ni][nj][1]==0) {
						v[ni][nj][1]=1;
						q.offer(new int[] {ni,nj,curr[2]-1, curr[3]+1});
					}
				}
			}
			for(int d=0; d<di.length; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni >=0 && nj >=0 && ni<N && nj<M && map[ni][nj] != 1 && v[ni][nj][2]==0) {
					v[ni][nj][2]=1;
					q.offer(new int[] {ni,nj,curr[2], curr[3]+1});
				}
			}
			
			
			
		}
		
		System.out.println(-1);

	}
	

}
