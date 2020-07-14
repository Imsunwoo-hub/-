package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_어른상어 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int[][][] tmap = new int[N][N][2];
		ArrayList<int[]> list = new ArrayList<>();
		
		int[][] map = new int[N][N];
		int[] dir = new int[M];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
				if(map[i][j] != 0) {
					list.add(new int[] {i,j, map[i][j]});
					tmap[i][j][0] = map[i][j];
					tmap[i][j][1] = K;
				}
			}
		}
		String[] d = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			dir[i] = Integer.parseInt(d[i])-1;
		}
		
		int[][][] pd = new int[M][4][4];
		for(int i=0; i<M*4; i++) {
			String[] m = br.readLine().split(" ");
			for(int j=0; j<4; j++) {
				pd[i/4][i%4][j] = Integer.parseInt(m[j])-1;
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int result = -1;
		int time = 0;
		while(time <= 1000) {
			//for(int[] l:list) System.out.println(Arrays.toString(l));
			//System.out.println();
			if(M==1) {
				result = time;
				break;
			}
			
			//이동
			int[][][] ttmap = new int[N][N][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ttmap[i][j][0] = tmap[i][j][0];
					ttmap[i][j][1] = tmap[i][j][1];
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				int curr[] = list.get(i);
				int bol = 0;
				for(int j=0; j<4; j++) {
					int ni = curr[0]+di[pd[curr[2]-1][dir[curr[2]-1]][j]];
					int nj = curr[1]+dj[pd[curr[2]-1][dir[curr[2]-1]][j]];
					if(ni>=0 && nj>=0 && ni<N && nj<N && tmap[ni][nj][0]==0) {
						bol = 1;
						if(ttmap[ni][nj][0]!=0) {
							//지가 작을때
							if(ttmap[ni][nj][0] > curr[2]) {
								int t = ttmap[ni][nj][0];
								ttmap[ni][nj][0] = curr[2];
								ttmap[ni][nj][1] = K;
								M--;
								dir[curr[2]-1] = pd[curr[2]-1][dir[curr[2]-1]][j];
								list.set(i, new int[] {ni, nj, curr[2]});
								for(int k=0; k<list.size(); k++) {
									if(list.get(k)[2] == t) {
										list.remove(k);
										break;
									}
								}
								i--;
							}
							// 아닐때
							else {
								list.remove(i);
								i--;
								M--;
							}
						}
						else {
							ttmap[ni][nj][0] = curr[2];
							ttmap[ni][nj][1] = K;
							dir[curr[2]-1] = pd[curr[2]-1][dir[curr[2]-1]][j];
							list.set(i, new int[] {ni, nj, curr[2]});
						}
						break;
					}
				}
				if(bol==0) {
					for(int j=0; j<4; j++) {
						int ni = curr[0]+di[pd[curr[2]-1][dir[curr[2]-1]][j]];
						int nj = curr[1]+dj[pd[curr[2]-1][dir[curr[2]-1]][j]];
						if(ni>=0 && nj>=0 && ni<N && nj<N && tmap[ni][nj][0]==curr[2]) {
							ttmap[ni][nj][1] = K;
							dir[curr[2]-1] = pd[curr[2]-1][dir[curr[2]-1]][j];
							list.set(i, new int[] {ni, nj, curr[2]});
							break;
						}
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					tmap[i][j][0] = ttmap[i][j][0];
					tmap[i][j][1] = ttmap[i][j][1];
				}
			}
			//냄새제거
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(tmap[i][j][0] != 0) {
						tmap[i][j][1] -= 1;
						if(tmap[i][j][1]==0) tmap[i][j][0] = 0;
					}
				}
			}
			for(int[] l:list) tmap[l[0]][l[1]][1] = K; 
			
			time++;
		}
		
		System.out.println(result);
	}

}
