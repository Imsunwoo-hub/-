package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_스타트택시 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
			}
		}
		String[] st = br.readLine().split(" ");
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				int r = Integer.compare(arg0[2], arg1[2]);
				if(r==0) r = Integer.compare(arg0[0], arg1[0]);
				if(r==0) r = Integer.compare(arg0[1], arg1[1]); 
				return r;
			}
		});
		q.offer(new int[] {Integer.parseInt(st[0])-1,Integer.parseInt(st[1])-1,0, K});
		int[][] smap = new int[N][N];
		int[][] emap = new int[M+1][2];
		int[][] v = new int[N][N];
		for(int i=0; i<M; i++) {
			String[] p = br.readLine().split(" ");
			smap[Integer.parseInt(p[0])-1][Integer.parseInt(p[1])-1] = i+1;
			emap[i+1][0] = Integer.parseInt(p[2])-1;
			emap[i+1][1] = Integer.parseInt(p[3])-1;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[2], arg1[2]);
			}
		});
		
		int result = -1;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[3]<0) break;
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]]=1;
				
				int bol = 0;
				if(smap[curr[0]][curr[1]]>0) {
					pq.clear();
					pq.offer(new int[] {curr[0], curr[1], 0, curr[3], smap[curr[0]][curr[1]]});
					smap[curr[0]][curr[1]] = 0;
					int[][] pv = new int[N][N];
					while(!pq.isEmpty()) {
						int pcurr[] = pq.poll();
						if(pcurr[3]< 0) break;
						
						if(pv[pcurr[0]][pcurr[1]]==0) {
							pv[pcurr[0]][pcurr[1]]=1;
							if(emap[pcurr[4]][0] == pcurr[0] && emap[pcurr[4]][1] == pcurr[1]) {
								bol = 1;
								M--;
								if(M==0) {
									result = pcurr[3]+(pcurr[2]*2);
								}
								for(int i=0; i<N; i++) {
									for(int j=0; j<N; j++) {
										v[i][j] = 0;
									}
								}
								q.clear();
								q.add(new int[] {pcurr[0], pcurr[1], 0, pcurr[3]+(pcurr[2]*2)});
								//System.out.println(pcurr[0]+", "+pcurr[1]+", "+ pcurr[3]+(pcurr[2]*2));
								break;
							}
							
							for(int d=0; d<4; d++) {
								int ni = pcurr[0]+di[d];
								int nj = pcurr[1]+dj[d];
								if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]==0 && pv[ni][nj]==0) {
									pq.offer(new int[] {ni,nj, pcurr[2]+1, pcurr[3]-1, pcurr[4]});
								}
							}
							
						}
					}
				}
				if(bol==1) {
					if(M==0) break;
					continue;
				}
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj]==0 && v[ni][nj]==0) {
						q.offer(new int[] {ni,nj,curr[2]+1, curr[3]-1});
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
