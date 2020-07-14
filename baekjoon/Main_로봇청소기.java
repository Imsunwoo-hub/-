package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_로봇청소기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] ia = new int[N][M];
		
		String[] temp = br.readLine().split(" ");
		int[] cleaner = new int[3];
		cleaner[0] = Integer.parseInt(temp[0]);
		cleaner[1] = Integer.parseInt(temp[1]);
		cleaner[2] = Integer.parseInt(temp[2]);
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j =0; j<M; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
			}
		}
		int[] di = {-1,0,1,0};
		int[] dj = {0,1,0,-1};
		Queue<int[]> q = new LinkedList<>();
		
		int count =0;
		
		q.offer(cleaner);
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			
			if(ia[curr[0]][curr[1]]==0) {
				count++;
				ia[curr[0]][curr[1]]=-1;
			}
			
			for(int d=0; d<di.length; d++) {
				int w = (curr[2]+3-d) % 4;
				
				int ni = curr[0]+di[w];
				int nj = curr[1]+dj[w];
				if(ni>=0 && nj>=0 && ni<N && nj<M && ia[ni][nj] == 0) {
					q.offer(new int[] {ni,nj,w});
					break;
				}
			}
			
			if(q.isEmpty()) {
				int ni = curr[0]+di[(curr[2]+2)%4];
				int nj = curr[1]+dj[(curr[2]+2)%4];
				if(ni>=0 && nj>=0 && ni<N && nj<M && ia[ni][nj] != 1) {
					q.offer(new int[] {ni,nj,curr[2]});
				}
			}
			
			if(q.isEmpty()) break;
			
		}
		
		
		System.out.println(count);
	}

}
