package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_단지번호붙이기 {
	
	static int N, temp, map[][], v[][];
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new int[N][N];
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && v[i][j]==0) {
					cnt++;
					temp=0;
					dfs(i,j,1);
					list.add(temp);
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int l:list) System.out.println(l);

	}
	
	public static void dfs(int i, int j, int c) {
		temp++;
		v[i][j] = 1;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj >=0 && ni<N && nj<N && map[ni][nj]==1 && v[ni][nj]==0) {
				dfs(ni,nj,c+1);
			}
		}
	}

}
