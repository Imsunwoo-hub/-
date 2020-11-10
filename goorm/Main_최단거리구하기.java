package goorm;

import java.io.*;
import java.util.*;
public class Main_최단거리구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++){
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				return Integer.compare(o1[2], o2[2]);
			}
		});
		int[][] v = new int[N][N];
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		q.offer(new int[] {0,0,1});
		v[0][0] = 1;
		while(!q.isEmpty()){
			int[] curr = q.poll();
			if(curr[0]==N-1 && curr[1]==N-1){
				System.out.println(curr[2]);
				break;
			}
			for(int d=0; d<4; d++){
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0 && map[ni][nj]==1){
					v[ni][nj]=1;
					q.offer(new int[] {ni,nj,curr[2]+1} );
				}
			}
		}
	}
}