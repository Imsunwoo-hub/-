package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.print.attribute.standard.PrintQuality;

public class Main_놀이공원 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][] v = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2],o2[2]);
			}
		});
		
		q.offer(new int[] {0,0,1});
		
		int result = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]]=1;
				
				if(curr[0]==N-1 && curr[1]==M-1) {
					result = curr[2];
					break;
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					
					if(ni>=0 && nj>=0 && ni<N && nj<M && Math.abs(map[curr[0]][curr[1]]-map[ni][nj]) <= 1 && v[ni][nj]==0) {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
		}
		
		System.out.println(result);

	}

}
