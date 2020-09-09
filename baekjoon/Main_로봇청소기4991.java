package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_로봇청소기4991 {
	
	static int result, N, M;
	static int[] di = {-1,1,0,0}; 
	static int[] dj = {0,0,-1,1};
	static char[][] map;
	static ArrayList<int[]> list;
	static int[] data;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			
			if(N==0 && M==0) break;
			
			map = new char[M][N];
			int[][] v = new int[M][N];
			int[] start = new int[2]; 
			int cnt = 0;
			list = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				String t= br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = t.charAt(j);
					if(map[i][j]=='o') {
						start[0] = i;
						start[1] = j;
					}
					if(map[i][j]=='*') {
						cnt++;
						list.add(new int[] {i,j});
					}
				}
			}
			
			int[] ia = new int[list.size()];
			
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					
					return  Integer.compare(o1[2], o2[2]);
				}
			});
			
			q.offer(new int[] {start[0], start[1], 0});
			
			
			while(!q.isEmpty()) {
				int curr[] = q.poll();
				
				if(v[curr[0]][curr[1]]==0) {
					
					v[curr[0]][curr[1]] = 1;
					
					for(int i=0; i<list.size(); i++) {
						if(curr[0]==list.get(i)[0] && curr[1]==list.get(i)[1]) {
							if(ia[i]==0) {
								ia[i] = curr[2];
								cnt--;
							}
						}
					}
					if(cnt==0) break;
					
					for(int d=0; d<4; d++) {
						int ni = curr[0]+di[d];
						int nj = curr[1]+dj[d];
						
						if(ni>=0 && nj>=0 && ni<M && nj<N && map[ni][nj] != 'x' && v[ni][nj]==0) {
							q.offer(new int[] {ni,nj, curr[2]+1});
						}
					}
					
				}
				
			}
			
			int bol = 0;
			
			for(int i=0; i<ia.length; i++) {
				if(ia[i]==0) {
				bol = 1;
				break;
				}
			}
			if(bol==1) System.out.println("-1");
			
			else {
				result = Integer.MAX_VALUE;
				int[][] gp = new int[list.size()][list.size()];
				
				//System.out.println(Arrays.toString(ia));
				
				for(int i=0; i<list.size(); i++) {
					
					q.clear();
					v = new int[M][N];
					q.offer(new int[] {list.get(i)[0], list.get(i)[1], 0});
					int end = list.size()-1;
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						
						if(v[curr[0]][curr[1]]==0) {
							v[curr[0]][curr[1]] = 1;
							
							for(int j=0; j<list.size(); j++) {
								if(j==i) continue;
								if(curr[0]==list.get(j)[0] && curr[1]==list.get(j)[1]) {
									end--;
									if(gp[i][j]==0) gp[i][j] = curr[2];
								}
								
								if(end==0) break;
								
								for(int d=0; d<4; d++) {
									int ni = curr[0]+di[d];
									int nj = curr[1]+dj[d];
									
									if(ni>=0 && nj>=0 && ni<M && nj<N && map[ni][nj] != 'x' && v[ni][nj]==0) {
										q.offer(new int[] {ni,nj, curr[2]+1});
									}
								}
							}
						}
					}
					
				}
				data = new int[list.size()];
				for(int i=0; i<list.size(); i++) data[i] = i;
				perm(0, ia,gp);
				System.out.println(result);
			}

			
		}

	}
	
	public static void perm(int n,int[] ia, int[][] gp) {
		if(n==list.size()) {
			
			int sum = ia[data[0]];
			
			for(int i=1; i<data.length; i++) {
				sum += gp[data[i-1]][data[i]];
			}
			if(sum < result) result = sum;
			
			return;
		}
		for(int i=n; i<list.size(); i++) {
			swap(n,i);
			perm(n+1,ia, gp);
			swap(i,n);
		}
	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
