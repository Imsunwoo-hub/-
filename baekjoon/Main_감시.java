package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_감시 {
	
	static int count,N,M, result, data[];
	static int[][] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		count = 0;
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(t[j]);
				if(map[i][j] > 0 && map[i][j] <6) {
					count++;
				}
			}
		}
		data = new int[count];
		result = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(result);
	}
	
	public static void dfs(int c) {
		if(c==count) {
			//System.out.println(Arrays.toString(data));
			int[][] tmap = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					tmap[i][j] = map[i][j];
				}
			}
			int idx = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int cam = tmap[i][j];
					if(cam > 0 && cam < 6) {
						if(cam == 1) cam1(tmap, data[idx], i,j);
						else if(cam== 2) cam2(tmap, data[idx],i,j);
						else if(cam==3) cam3(tmap, data[idx],i,j);
						else if(cam==4) cam4(tmap, data[idx],i,j );
						else if(cam==5) cam5(tmap, data[idx],i,j);
						idx++;
					}
				}
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tmap[i][j] == 0){
						cnt++;
					}
				}
			}
			if(result > cnt) result = cnt;
			return;
		}
		
		for(int i=0; i<4; i++) {
			data[c] = i;
			dfs(c+1);
		}
		
	}
	
	
	
	public static void cam1(int[][] tmap, int d, int i, int j) {
		if(d==0) {
			for(int b=j; b<M; b++) {
				if(tmap[i][b]==0) {
					tmap[i][b] = -1;
				}
				if(tmap[i][b]==6) break;
			}
		}else if(d==1) {
			for(int a=i; a<N; a++) {
				if(tmap[a][j]==0) tmap[a][j] = -1;
				if(tmap[a][j]==6) break;
			}
		}else if(d==2) {
			for(int b=j; b>=0; b--) {
				if(tmap[i][b]==0) {
					tmap[i][b] = -1;
				}
				if(tmap[i][b]==6) break;
			}
			
		}else if(d==3) {
			for(int a=i; a>=0; a--) {
				if(tmap[a][j]==0) {
					tmap[a][j] = -1;
				}
				if(tmap[a][j]==6) break;
			}
		}
	}
	public static void cam2(int[][] tmap, int d, int i, int j) {
			if(d%2==0) {
				cam1(tmap, 0, i,j);
				cam1(tmap, 2, i,j);
			}
			else {
				cam1(tmap, 1,i,j);
				cam1(tmap, 3,i,j);
			}
			
		}
	public static void cam3(int[][] tmap, int d, int i, int j) {
		if(d==0) {
			cam1(tmap, 0,i,j);
			cam1(tmap,3,i,j);
		}
		if(d==1) {
			cam1(tmap, 0,i,j);
			cam1(tmap,1,i,j);
					
		}
		if(d==2) {
			cam1(tmap, 1,i,j);
			cam1(tmap,2,i,j);
		}
		if(d==3) {
			cam1(tmap, 2,i,j);
			cam1(tmap,3,i,j);
		}

	}
	public static void cam4(int[][] tmap, int d, int i, int j) {
		if(d==0) {
			cam1(tmap, 2,i,j);
			cam1(tmap,3,i,j);
			cam1(tmap, 0,i,j);
		}
		if(d==1) {
			cam1(tmap, 3,i,j);
			cam1(tmap,0,i,j);
			cam1(tmap, 1,i,j);
		}
		if(d==2) {
			cam1(tmap, 0,i,j);
			cam1(tmap,1,i,j);
			cam1(tmap, 2,i,j);
		}
		if(d==3) {
			cam1(tmap, 1,i,j);
			cam1(tmap,2,i,j);
			cam1(tmap, 3,i,j);
		}
	}
	public static void cam5(int[][] tmap, int d, int i, int j) {
		cam1(tmap, 0, i,j);
		cam1(tmap, 1, i,j);
		cam1(tmap, 2, i,j);
		cam1(tmap, 3, i,j);
	}


}
