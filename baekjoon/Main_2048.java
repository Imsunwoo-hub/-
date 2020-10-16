package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2048 {
	
	static int result, N;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		result = 0;
		
		dfs(0, ia);
		
		System.out.println(result);
		
	}
	
	public static void dfs(int c, int[][] map) {
		if(c==5) {
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > max) max = map[i][j];
				}
			}
			if(max > result) result = max;
			return;
		}
		//for(int[] m:map) System.out.println(Arrays.toString(m));
		//System.out.println();
		for(int d=0; d<4; d++) {
			rotate(map);
			int[][] tmap = move(map);
			dfs(c+1, tmap);
		}
	}
	
	public static void rotate(int[][] map) {
		int[][] tmap = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmap[i][j] = map[N-1-j][i];
			}
		}
		
		copy(tmap, map);
		
	}
	
	public static void copy(int[][] omap, int[][] cmap) {
		for(int i=0; i<N; i++ ) {
			for(int j=0; j<N; j++) {
				cmap[i][j] = omap[i][j];
			}
		}
	}
	
	public static int[][] move(int[][] map){
		int[][] tmap = new int[N][N];
		int[][] v = new int[N][N];
	
		copy(map, tmap);
		
		for(int i=N-2; i>=0; i--) {
			for(int j=0; j<N; j++) {
				if(tmap[i][j] != 0) {
					int ni = i+1;
					while(ni<N) {
						if(tmap[ni][j] != 0) break;
						ni++;
					}
					if(ni >= N) {
						tmap[ni-1][j] = tmap[i][j];
						tmap[i][j] = 0;
					}
					else if(tmap[ni][j] != 0) {
						if(tmap[ni][j]==tmap[i][j] && v[ni][j]==0) {
							v[ni][j] = 1;
							tmap[ni][j] *= 2;
							tmap[i][j] = 0;
						}
						else {
							tmap[ni-1][j] = tmap[i][j];
							if(i != ni-1)tmap[i][j] = 0;
						}
					}
					
				}
			}
		}
		
		
		return tmap;
	}

}
