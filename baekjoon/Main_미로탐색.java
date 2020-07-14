package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_미로탐색 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][] v = new int[N][M];
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(t.charAt(j)+"");
			}
		}
		
		int result = 0;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				
				return Integer.compare(arg0[2], arg1[2]);
			}
		});
		
		q.offer(new int[] {0,0,1});
		
		while(!q.isEmpty())
		{
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				
				if(curr[0]== N-1 && curr[1]== M-1) {
					result = curr[2];
					break;
				}
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==1 && v[ni][nj]==0) {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
			
		}
		
		System.out.println(result);
	}

}
