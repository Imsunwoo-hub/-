package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_아맞다우산 {
	
	static int N,M,result;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] v;
	static char[][] map;
	static ArrayList<int[]> list;
	static int[] start;
	static int[] end;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[1]);
		M = Integer.parseInt(s[0]);
		
		map = new char[N][M];
		start = new int[2];
		end = new int[2];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j]=='X') list.add(new int[] {i,j});
				if(map[i][j]=='S') {
					start[0] = i;
					start[1] = j;
					
				}
				if(map[i][j]=='E') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		result = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);
		
	}
	
	public static void perm(int n) {
		if(n==list.size()) {
			int temp = bfs(start[0], start[1]);
			if(temp < result) result = temp;
			return;
		}
		
		for(int i=n; i<list.size(); i++) {
			swap(i,n);
			perm(n+1);
			swap(i,n);
		}
	}
	
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int curr[] = list.get(i);
		list.set(i, new int[] {list.get(j)[0], list.get(j)[1]});
		list.set(j, new int[] {curr[0], curr[1]});
	}
	
	public static int bfs(int i, int j) {
		int sum = 0;
		int idx = 0;
		v = new int[N][M];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		q.offer(new int[] {i,j,0});
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				
				if(idx<list.size()) {
					if(curr[0]==list.get(idx)[0] && curr[1]==list.get(idx)[1]) {
						sum+=curr[2];
						idx++;
						q.clear();
						v = new int[N][M];
						q.offer(new int[] {curr[0],curr[1],0});
						continue;
					}
				}
				else {
					if(curr[0]==end[0] && curr[1]==end[1]) {
						sum+=curr[2];
						break;
					}
				}
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0 && map[ni][nj]!='#') {
						q.offer(new int[] {ni,nj,curr[2]+1});
					}
				}
			}
		}
		
		
		
		return sum;
	}

}
