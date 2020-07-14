package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_빵집 {
	
	public static int[][] v;
	public static char[][] ca; 
	public static int[] di = {-1,0,1};
	public static int[] dj = {1,1,1};
	public static int count,r,c;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		ca = new char[r][c];
		v = new int[r][c];
		for(int i=0; i<r; i++) {
			String t = br.readLine();
			for(int j=0; j<c; j++) {
				ca[i][j] = t.charAt(j);
			}
		}
		count = 0;
		for(int i=0; i<r; i++) {
			dfs(i,0);
		}
		
		System.out.println(count);
	}
	public static int dfs(int i, int j) {
		if(j==c-1) {
			count++;
			return -1;
		}
		v[i][j] = 1;
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<r && nj>=0 && nj<c && v[ni][nj]==0 && ca[ni][nj]!='x') {
				int x  = dfs(ni,nj);
				if(x == -1) return -1;
			}
		}
		return 0;
	}

}
