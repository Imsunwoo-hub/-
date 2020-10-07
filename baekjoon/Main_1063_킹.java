package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1063_킹 {
	
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int[] king = new int[2];
		king[0] = 8-(s[0].charAt(1)-'0');
		king[1] = s[0].charAt(0)-'A';
		int[] stone = new int[2];
		stone[0] = 8-(s[1].charAt(1)-'0');
		stone[1] = s[1].charAt(0)-'A';
		int N = Integer.parseInt(s[2]);
		
		int[][] map = new int[8][8];
		map[king[0]][king[1]] = 1;
		map[stone[0]][stone[1]] = 2;
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			int d = dir(t);
			if(bol(king[0], king[1], d)) continue;
			int ni = king[0]+di[d];
			int nj = king[1]+dj[d];
			if(ni==stone[0] && nj==stone[1]) {
				if(bol(stone[0], stone[1], d)) continue;
				map[king[0]][king[1]] = 0;
				map[ni][nj] = 1;
				king[0] = ni;
				king[1] = nj;
				ni = stone[0]+di[d];
				nj = stone[1]+dj[d];
				map[ni][nj] = 2;
				stone[0] = ni;
				stone[1] = nj;
			}
			else {
				map[king[0]][king[1]] = 0;
				map[ni][nj] = 1;
				king[0] = ni;
				king[1] = nj;
			}
			
		}
	
		 
		System.out.println(((char)(king[1]+'A') ) +""+ (8-king[0]));
		System.out.println(((char)(stone[1]+'A') ) +""+ (8-stone[0]));

	}
	public static boolean bol(int i, int j, int d) {
		int ni = i+di[d];
		int nj = j+dj[d];
		if(ni<0 || nj<0 || ni>7 || nj>7) return true;
		else return false;
	}
	
	public static int dir(String t) {
		if(t.equals("R")) return 2; 
		else if(t.equals("L")) return 6; 
		else if(t.equals("B")) return 4; 
		else if(t.equals("T")) return 0; 
		else if(t.equals("RT")) return 1; 
		else if(t.equals("LT")) return 7; 
		else if(t.equals("RB")) return 3; 
		else return 5; 
	}

}
