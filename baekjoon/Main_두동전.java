package beakjoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_두동전 {
	
	static int N,M,result;
	static char[][] map;
	//static int[][] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new char[N][M];
		//v = new int[N][M];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j] == 'o') {
					map[i][j] = '.';
					//v[i][j]++;
					list.add(new int[] {i,j});
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		dfs(list, 0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	public static void dfs(ArrayList<int[]> l, int cnt) {
		if(cnt > 10) return;
		if(l.size()==0) return;
		if(l.size()==1) {
			if(cnt < result) result = cnt;
			return;
		}
		
		for(int d=0; d<4; d++) {
			
			ArrayList<int[]> nl = new ArrayList<>();
			
			for(int i=0; i<l.size(); i++) {
				int[] curr = l.get(i);
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				
				if(ni < 0|| nj<0 || ni>=N || nj>=M) continue;
				
				if(map[ni][nj]=='.') {
					nl.add(new int[] {ni,nj});
				}
				else {
					nl.add(new int[] {curr[0], curr[1]});
				}
			}
			
			dfs(nl, cnt+1);
		}
	
	}

}
