package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_파이프옮기기 {
	
	static int result, N, map[][];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		result = 0;
		
		dfs(0,0,0,1,0);
		
		System.out.println(result);
	}
	
	
	static void dfs(int li, int lj, int ri, int rj, int state) {
		if(ri<0 || rj<0 || ri>=N || rj>=N  || li<0 || lj<0 || li>=N || lj>=N  ||  map[li][lj]==1 || map[ri][rj]==1) return;
		if((li==N-1 && lj==N-1)||(ri==N-1 && rj==N-1)) {
			result++;
			return;
		}
		
		if(state==0) {
			if(rj<N-1 && map[ri][rj+1]==0) {
				dfs(li, lj+1, ri, rj+1, 0);
			}
			if(ri<N-1 && rj<N-1 && map[ri][rj+1]==0 
					&& map[ri+1][rj+1]==0 && map[ri+1][rj]==0) {
				dfs(li, lj+1, ri+1, rj+1, 2);
			}
			
		}
		
		if(state==1) {
			if(ri<N-1 && map[ri+1][rj]==0) {
				dfs(li+1, lj, ri+1, rj, 1);
			}
			if(ri<N-1 && rj<N-1 && map[ri][rj+1]==0 &&
					map[ri+1][rj+1]==0 && map[ri+1][rj]==0) {
				dfs(li+1, lj, ri+1, rj+1, 2);
			}
		}
		
		if(state==2) {
			if(rj<N-1 && map[ri][rj+1]==0) {
				dfs(li+1, lj+1, ri, rj+1, 0);
			}
			if(ri<N-1 && map[ri+1][rj]==0)
			{
				dfs(li+1, lj+1, ri+1, rj, 1);
			}
			if(ri<N-1 && rj<N-1 &&  map[ri][rj+1]==0 &&
					map[ri+1][rj+1]==0 && map[ri+1][rj]==0 ) {
				dfs(li+1, lj+1, ri+1, rj+1, 2);
			}
			
		}
		
	}
}
