package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_알파벳 {
	
	static int R,C,result;
	static char[][] map;
	static int[] v;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		v = new int[26];
		
		for(int i=0; i<R; i++) {
			String t = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = t.charAt(j);
			}
		}
		
		result = 1;
		v[map[0][0]-'0'] = 1;
		dfs(0,0,1);
		System.out.println(result);
	}
	
	public static void dfs(int i, int j, int cnt) {
		if(cnt > result) result = cnt;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C && v[map[ni][nj]-'0']==0) {
				v[map[ni][nj]-'0']=1;
				dfs(ni,nj,cnt+1);
				v[map[ni][nj]-'0']=0;
			}
		}
	}

}
