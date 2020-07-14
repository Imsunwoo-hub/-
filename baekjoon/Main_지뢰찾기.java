package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_지뢰찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(s);
		
		char[][] ca = new char[N][N];
		int result = 0;
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<N; j++) {
				ca[i][j] = t.charAt(j);
				if(ca[i][j]=='#') result++;
			}
		}
		
		//탐색하면서 지워도 될거는 지우고 result--
		int[] di = {-1,-1,-1,0,1,1,1,0};
		int[] dj = {-1,0,1,1,1,0,-1,-1};
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				int bol = 0;
				for(int d=0; d<8; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ca[ni][nj]=='0') {
						bol = 1;
						break;
					}
				}
				if(bol==1) result--;
				else {
					for(int d=0; d<8; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ca[ni][nj] != '0' && ca[ni][nj] != '#') {
							ca[ni][nj] = (char) (((ca[ni][nj] -'0')-1)+'0');
						}
					}
				}
				
			}
		}
		
		System.out.println(result);

	}

}
