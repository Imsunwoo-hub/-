package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_음식물피하기 {
	
	static int N,M, map[][], v[][];
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		 M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		map = new int[N][M];
		v = new int[N][M];
		
		for(int i=0; i<K; i++) {
			s = br.readLine().split(" ");
			
			map[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
		}
		
		int result = 0;
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1 && v[i][j]==0) {
					int sum = dfs(i,j);
					if(sum > result) result = sum;
				}
			}
		}
		
		System.out.println(result);

	}
	
	public static int dfs(int i, int j) {
		int result = 1;
		v[i][j] = 1;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==1 && v[ni][nj] ==0) {
				result += dfs(ni,nj);
			}
		}
		
		return result;
	}

}
