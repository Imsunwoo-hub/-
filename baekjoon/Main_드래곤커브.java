package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main_드래곤커브 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		int[][] ia = new int[N][4]; 
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<4; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[] di = {0,-1, 0, 1};
		int[] dj = {1, 0,-1, 0};
		
		for(int k=0; k<N; k++) {
			
			int y = ia[k][1];
			int x = ia[k][0];
			int w = ia[k][2];
			int g = ia[k][3];
			int c = (int)Math.pow(2, g);
			ArrayList<Integer> wlist = new ArrayList<>();
			wlist.add(w);
			map[y][x] = 1;
			
			int ni = y;
			int nj = x;
			
			while(true) {
				if(c==wlist.size()) break;
				int end = wlist.size()-1;
				
				for(int i=end; i>=0; i--) {
					wlist.add((wlist.get(i)+1)%4);
					if(wlist.size()==c) break;
				}
				
				
			}	
			
			for(int i:wlist) {
				ni = ni + di[i];
				nj = nj + dj[i];
				map[ni][nj] = 1;
			}
		
		}
		
		int count =0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1) {
					if(map[i+1][j]==1 && map[i][j+1]==1 && map[i+1][j+1]==1 ) count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
