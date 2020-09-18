package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_소가길을건너간이유6 {
	
	static int N,K,R;
	static int[][] map, v, gp;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		
		map = new int[N][N];
		
		gp = new int[N*N][N*N];
		ArrayList<int[]> list = new ArrayList<>();
	
		for(int i=0; i<R; i++) {
			s = br.readLine().split(" ");
			int r1 = Integer.parseInt(s[0])-1;
			int c1 = Integer.parseInt(s[1])-1;
			int r2 = Integer.parseInt(s[2])-1;
			int c2 = Integer.parseInt(s[3])-1;
			gp[r1*N+c1][r2*N+c2] = 1;
			gp[r2*N+c2][r1*N+c1] = 1;
		}
		
		for(int i=0; i<K; i++) {
			s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0])-1;
			int c = Integer.parseInt(s[1])-1;
			map[r][c] = 1;
			list.add(new int[] {r,c});
		}
		
		int result = 0;
		
		for(int i=0; i<list.size(); i++) {
			int curr[] = list.get(i);
			v = new int[N][N];
			dfs(curr[0], curr[1]);
			for(int j=i; j<list.size(); j++) {
				if(v[list.get(j)[0]][list.get(j)[1]]==0) result++;
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int j) {
		v[i][j] = 1;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<N) {
				if(gp[i*N+j][ni*N+nj]==0 && v[ni][nj] == 0) {
					dfs(ni,nj);
				}
			}
		}
	}

}
