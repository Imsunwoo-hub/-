package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_톱니바퀴 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] gears = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j] = s.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int[][] commands = new int[K][2];
		
		for(int i=0; i<K; i++) {
			String[] s = br.readLine().split(" ");
			commands[i][0] = Integer.parseInt(s[0])-1;
			commands[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int i=0; i<K; i++) {
			dfs(commands[i][0], commands[i][1], gears, -1);
		}
		
		int result = 0;
		if(gears[0][0]==1) result += 1;
		if(gears[1][0]==1) result += 2;
		if(gears[2][0]==1) result += 4;
		if(gears[3][0]==1) result += 8;
		
		System.out.println(result);
	}
	
	public static void dfs(int n, int d, int[][] gears, int before) {
		if(n-1 >=0 && gears[n][6] != gears[n-1][2] && n-1!=before) {
			if(d==1) dfs(n-1,-1 ,gears,n);
			else dfs(n-1, 1 ,gears,n);
		}
		if(n+1 < 4 && gears[n][2] != gears[n+1][6] && n+1!=before ) {
			if(d==1) dfs(n+1,-1 ,gears,n);
			else dfs(n+1, 1 ,gears,n);
		}
		if(d==1) {
			int temp = gears[n][7];
			for(int i=7; i>0; i--) gears[n][i] = gears[n][i-1];
			gears[n][0] = temp;
		}
		else {
			int temp = gears[n][0];
			for(int i=0; i<7; i++) gears[n][i] = gears[n][i+1];
			gears[n][7] = temp;
		}
	}

}
