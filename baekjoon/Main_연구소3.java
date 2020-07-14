package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_연구소3 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] data, map; 
	static ArrayList<int[]> list;
	static int N,M,result, count;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][N];
		list = new ArrayList<>(); 
		count = 0;
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
				if(map[i][j]==2) list.add(new int[] {i,j});
				if(map[i][j]==0) count++;
			}
		}
		data = new int[M][2];
		result = -1;
		if(count==0) result = 0;
		dfs(0, 0, new ArrayList<Integer>());
		System.out.println(result);
	}
	
	public static void dfs(int i, int c, ArrayList<Integer> l) {
		if(c==M) {
			int[][] tmap = new int[N][N];
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					tmap[a][b] = map[a][b];
				}
			}
			for(int a=0; a<l.size(); a++) {
				data[a][0] = list.get(l.get(a))[0];
				data[a][1] = list.get(l.get(a))[1];
			}
			bfs(data,tmap);
			return;
		}
		if(i==list.size()) return;
		l.add(i);
		dfs(i+1, c+1, l);
		l.remove(l.size()-1);
		dfs(i+1,c,l);
		
	}
	
	public static void bfs(int[][] data, int[][] tmap) {
		int[][] v = new int[N][N];
		int cnt = count;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for(int i=0; i<data.length; i++) {
			q.offer(new int[] {data[i][0], data[i][1], 0});
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				if(tmap[curr[0]][curr[1]]==0) {
					tmap[curr[0]][curr[1]]=2;
					cnt--;
					if(cnt==0) {
						if(result == -1) result = curr[2];
						else {
							if(result > curr[2]) result = curr[2];
						}
						break;
					}
				}
				
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni >=0 && nj>=0 && ni<N && nj<N && (tmap[ni][nj]==0 || tmap[ni][nj]==2) && v[ni][nj]==0) {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
				
			}
		}
	}

}

