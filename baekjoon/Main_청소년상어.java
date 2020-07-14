package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_청소년상어 {
	
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,-1,-1,-1,0,1,1,1};
	static int result;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		
		int[][] nmap = new int[4][4];
		int[][] dmap = new int[4][4];
		
		for(int i=0; i<4; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<8; j++) {
				if(j%2==0) {
					nmap[i][j/2] = Integer.parseInt(s[j]);
				}
				else {
					dmap[i][j/2] = Integer.parseInt(s[j])-1;
				}
			}
		}
		result = nmap[0][0];
		int startd = dmap[0][0];
		nmap[0][0] = -1;
		dmap[0][0] = -1;
		
		dfs(0,0, startd, nmap, dmap, result);
		
		
		System.out.println(result);

	}
	
	public static void dfs(int x, int y, int d, int[][] nm, int[][] dm, int temp) {
		if(temp > result) result = temp;
		int[][] nnm = new int[4][4];
		int[][] ndm = new int[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				nnm[i][j] = nm[i][j];
				ndm[i][j] = dm[i][j];
			}
		}
		list.clear();
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(nm[i][j] > 0) list.add(new int[] {i, j, nm[i][j], dm[i][j]});
			}
		}
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return Integer.compare(arg0[2], arg1[2]);
			}
		});
		//아이들 움직이기
		for(int i=0; i<list.size(); i++) {
			int[] curr = list.get(i);
			for(int k=0; k<=8; k++) {
				int ni = curr[0] + di[(curr[3]+k)%8];
				int nj = curr[1] + dj[(curr[3]+k)%8];
				if(ni<0 || nj<0 || ni>=4 || nj>=4 || nnm[ni][nj]==-1) continue;
				else if(nnm[ni][nj]==0) {
					nnm[ni][nj] = nnm[curr[0]][curr[1]];
					ndm[ni][nj] = (curr[3]+k)%8;
					nnm[curr[0]][curr[1]] = 0;
					ndm[curr[0]][curr[1]] = 0;
					list.set(i, new int[] {ni,nj,curr[2], (curr[3]+k)%8});
					break;
				}
				else if(nnm[ni][nj] > 0) {
					int tn = nnm[ni][nj];
					int td = ndm[ni][nj];
					nnm[ni][nj] = nnm[curr[0]][curr[1]];
					ndm[ni][nj] = (curr[3]+k)%8;
					nnm[curr[0]][curr[1]] = tn;
					ndm[curr[0]][curr[1]] = td;
					list.set(i, new int[] {ni,nj,curr[2], (curr[3]+k)%8});
					for(int j=0; j<list.size(); j++) {
						if(list.get(j)[2] == tn) {
							list.set(j, new int[] {curr[0], curr[1], tn, td});
							break;
						}
					}
					break;
				}
			}
		}
		//상어 이동
		for(int i=1; i<=4; i++) {
			int ni = x+di[d]*i;
			int nj = y+dj[d]*i;
			if(ni<0 || nj<0 || ni>=4 || nj>=4 || nnm[ni][nj]==0) continue;
			else {
				int nd = ndm[ni][nj];
				int nt = nnm[ni][nj];
				nnm[x][y] = 0;
				ndm[x][y] = 0;
				nnm[ni][nj] = -1;
				ndm[ni][nj] = -1; 
				dfs(ni,nj,nd, nnm, ndm, temp+nt);
				nnm[x][y] = -1;
				ndm[x][y] = -1;
				nnm[ni][nj] = nt;
				ndm[ni][nj] = nd;
			}
		}
	}
}
