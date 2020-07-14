package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_인구이동 {
	
	public static int N, ia[][], v[][],L, R;
	public static List<int[]> list;
	public static int[] di = {-1,1,0,0,}; 
	public static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] t = br.readLine().split(" ");
		N = Integer.parseInt(t[0]);
		L = Integer.parseInt(t[1]);
		R = Integer.parseInt(t[2]);
		
		ia = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
	
		int count = 0;
		list = new ArrayList<>();
		while(true) {
			v = new int[N][N];
			int bol = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(v[i][j]==0) {
						list.clear();
						bfs(i,j);
						if(list.size()==1) {
							v[i][j] =0;
							continue;
						}
						else {
							//System.out.println(list.size());
							bol = 1;
							int c = list.size();
							int sum = 0;
							for(int[] l:list) {
								sum += ia[l[0]][l[1]];
							}
							for(int[] l:list) {
								ia[l[0]][l[1]] = sum/c;
							}
						}
					}
				}
			}
			//for(int[] i : ia) System.out.println(Arrays.toString(i));
			if(bol==1) count++;
			if(bol==0) break;
		}
		System.out.println(count);
	}
	
	public static void bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr= q.poll();
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				list.add(curr);
				for(int d=0; d<di.length; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && ni<N && nj>=0 && nj<N) {
							int temp = Math.abs(ia[curr[0]][curr[1]]-ia[ni][nj]);
							if(temp>=L && temp<=R) {
								q.offer(new int[] {ni,nj});
							}
					}
				}
			}
		}
	}
}