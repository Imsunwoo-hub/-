package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_경비원 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[K][2];
		
		for(int i=0; i<K; i++) {
			s = br.readLine().split(" ");
			if(Integer.parseInt(s[0])==1) {
				ia[i][0] = 0;
				ia[i][1] = Integer.parseInt(s[1]);
			}else if(Integer.parseInt(s[0])==2) {
				ia[i][0] = N;
				ia[i][1] = Integer.parseInt(s[1]);
			} else if(Integer.parseInt(s[0])==3) {
				ia[i][0] = Integer.parseInt(s[1]);
				ia[i][1] = 0;
			} else {
				ia[i][0] = Integer.parseInt(s[1]);
				ia[i][1] = M;
			}
			
		}
		
		int[] x = new int[2];
		s = br.readLine().split(" ");
		if(Integer.parseInt(s[0])==1) {
			x[0] = 0;
			x[1] = Integer.parseInt(s[1]);
		}else if(Integer.parseInt(s[0])==2) {
			x[0] = N;
			x[1] = Integer.parseInt(s[1]);
		} else if(Integer.parseInt(s[0])==3) {
			x[0] = Integer.parseInt(s[1]);
			x[1] = 0;
		} else {
			x[0] = Integer.parseInt(s[1]);
			x[1] = M;
		}
		
		int result = 0;
		
		for(int i=0; i<K; i++) {
			result += rotate(x, ia[i], N, M);
		}
		
		System.out.println(result);

	}
	
	public static int rotate(int[] x, int[] y, int N, int M) {
		int result = 0;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int[][] v = new int[N+1][M+1];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		q.offer(new int[] {x[0],x[1],0});
		v[x[0]][x[1]] = 1;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==y[0] && curr[1]==y[1]) {
				result = curr[2];
				break;
			}
			
			for(int d=0; d<4; d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				
				if(ni>=0 && nj>=0 && ni<=N && nj<=M && v[ni][nj]==0) {
					if(ni==0 || ni==N || nj==0 || nj==M) {
						v[ni][nj] = 1;
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
			
		}
		
		return result;
	}
	

}
