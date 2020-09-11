package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_크레이지아케이드 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[10][10];
		int[][] rmap = new int[10][10];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<10; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				rmap[i][j] = Integer.parseInt(s[j]);
				if(map[i][j]>0) q.offer(new int[] {i,j});
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][2];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			person[i][0] = Integer.parseInt(s[0])-1;
			person[i][1] = Integer.parseInt(s[1])-1;
		}
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int k = map[curr[0]][curr[1]];
			for(int d=0; d<4; d++) {
				for(int i=0; i<=k; i++) {
					int ni = curr[0]+di[d]*i;
					int nj = curr[1]+dj[d]*i;
					if(ni>=0 && nj>=0 && ni<10 && nj < 10) {
						if(map[ni][nj]==-1) break;
						if(map[ni][nj]==0 || map[ni][nj]==k) rmap[ni][nj] = -2;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(rmap[person[i][0]][person[i][1]]==0) rmap[person[i][0]][person[i][1]] = i+1;
		}
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(rmap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Character Information");
		for(int i=0; i<N; i++) {
			int[] p = person[i];
			if(rmap[p[0]][p[1]]==i+1) System.out.println("player "+(i+1) +" survive");
			else System.out.println("player "+(i+1)+" dead");
		}
	}

}
