package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


class Idx{
	int i;
	int j;
	int cnt;
	Idx(int i, int j, int cnt){
		this.i = i;
		this.j = j;
		this.cnt = cnt;
	}
}

public class Main_알고스팟 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = st.charAt(j)-'0';
				if(map[i][j]==1) cnt++;
			}
		}
		
		int[][][] v = new int[N][M][cnt+1];
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		PriorityQueue<Idx> q = new PriorityQueue<>(new Comparator<Idx>() {

			@Override
			public int compare(Idx o1, Idx o2) {
				
				return Integer.compare(o1.cnt, o2.cnt);
			}
		});
		
		q.offer(new Idx(0,0,0));
		v[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Idx curr = q.poll();
			
			if(curr.i==N-1 && curr.j==M-1) {
				System.out.println(curr.cnt);
				return;
			}
			
			for(int d=0; d<2; d++) {
				int ni = curr.i + di[d];
				int nj = curr.j + dj[d];
				if(ni >=0 && nj>=0 && ni<N && nj<M ){
					if(map[ni][nj]==1 && v[ni][nj][curr.cnt+1]==0) {
						v[ni][nj][curr.cnt+1] = 1;
						q.offer(new Idx(ni,nj,curr.cnt+1));
					}
					else if(map[ni][nj]==0 && v[ni][nj][curr.cnt]==0) {
						v[ni][nj][curr.cnt] = 1;
						q.offer(new Idx(ni,nj,curr.cnt));
					}
				}
			}
		}

	}
}
