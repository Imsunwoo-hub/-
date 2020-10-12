package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_9207_페그솔리테어 {
	
	static char[][] map;
	static ArrayList<int[]> list;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] result;

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			map = new char[5][9];
			list = new ArrayList<>();
			
			for(int i=0; i<5; i++) {
				String s = br.readLine();
				for(int j=0; j<9; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'o') list.add(new int[] {i,j});
				}
			}
			
			result = new int[2];
			result[0] = list.size();
			solve(list, 0);
			System.out.println(result[0]+" "+result[1]);
			br.readLine();
		}

	}
	
//	public static void dfs(int n) {
//		if(n==list.size()) {
//			//for(int[] i: list) System.out.print(Arrays.toString(i));
//			//System.out.println();
//			ArrayList<int[]> tlist = new ArrayList<>();
//			for(int[] l:list) tlist.add(l);
//			solve(tlist,0);
//			return;
//		}
//		for(int i=n; i<list.size(); i++) {
//			swap(n,i);
//			dfs(n+1);
//			swap(n,i);
//		}
//	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int[] t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}
	
	public static void solve(ArrayList<int[]> l, int c) {
		//for(char[] m:map) System.out.println(Arrays.toString(m));
		//System.out.println();
		if(l.size() <= result[0]) {
			if(l.size()<result[0]) {
				result[0] = l.size();
				result[1] = c;
			}
			else {
				if(c<result[1]) result[1] = c;
			}
		}
		for(int[] curr:l) {
			
			for(int d=0; d<4; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0 && nj>=0 && ni<5 && nj<9 && map[ni][nj]=='o') {
					if(ni+di[d]>=0 && ni+di[d]<5 && nj+dj[d]>=0 && nj+dj[d]<9 && map[ni+di[d]][nj+dj[d]]=='.') {
						ArrayList<int[]> tl = new ArrayList<>();
						for(int[] i:l) {
							if(curr[0] == i[0] && curr[1] == i[1]) continue;
							if(i[0]== ni && i[1] ==nj) continue;
							tl.add(i);
						}
						tl.add(new int[] {ni+di[d],nj+dj[d]});
						map[curr[0]][curr[1]]='.';
						map[ni][nj] = '.';
						map[ni+di[d]][nj+dj[d]] = 'o';
						solve(tl,c+1);
						map[curr[0]][curr[1]]='o';
						map[ni][nj] = 'o';
						map[ni+di[d]][nj+dj[d]] = '.';
					}
				}
			}	
		}
		
		
	}

}
