package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_미로만들기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[N][N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				ia[i][j] = s.charAt(j)-'0';
				if(ia[i][j]==0) cnt++;
			}
		}
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int[][][] v = new int[N][N][cnt+1];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		q.offer(new int[] {0,0,0});
		v[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==N-1 && curr[1]==N-1) {
				System.out.println(curr[2]);
				break;
			}
			
			for(int d=0; d<4; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<N) {
					if(ia[ni][nj]==1 && v[ni][nj][curr[2]]==0) {
						v[ni][nj][curr[2]]=1;
						q.offer(new int[] {ni,nj,curr[2]});
					}
					else if(ia[ni][nj]==0 && v[ni][nj][curr[2]+1]==0) {
						v[ni][nj][curr[2]+1]=1;
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
			
		}

	}

}
