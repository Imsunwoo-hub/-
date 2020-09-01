package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_체스말이동 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] v = new int[N][N];
		int[] start = new int[2];
		int[] end = new int[2];
		
		String[] s = br.readLine().split(" ");
		
		start[0] = Integer.parseInt(s[0])-1;
		start[1] = Integer.parseInt(s[1])-1;
		
		s = br.readLine().split(" ");
		end[0] = Integer.parseInt(s[0])-1;
		end[1] = Integer.parseInt(s[1])-1;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				
				return Integer.compare(arg0[2], arg1[2]);
			}
		});
		
		int[] di = {-1, -2, -2, -1,  1,  2, 2, 1};
		int[] dj = {-2, -1,  1,  2,  2,  1,-1,-2};
		
		q.offer(new int[] {start[0], start[1], 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]]=1;
				if(curr[0]==end[0] && curr[1]==end[1]) {
					System.out.println(curr[2]);
					break;
				}
				for(int d=0; d<8; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0) {
						q.offer(new int[] {ni,nj, curr[2]+1});
					}
				}
			}
			
		}

	}

}
