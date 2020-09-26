package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2580_스도쿠 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] ia = new int[9][9];
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<9; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
				if(ia[i][j] == 0 ) list.add(new int[] {i,j});
			}
		}
		
		dfs(0, list, ia);

	}
	
	public static int dfs(int n, ArrayList<int[]> list, int[][] ia) {
		if(n==list.size()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(ia[i][j] + " ");
				}
				System.out.println();
			}
			
			return 1;
		}
		for(int i=1; i<=9; i++) {
			if(backtraking(list.get(n), ia, i)) {
				ia[list.get(n)[0]][list.get(n)[1]] = i;
				int bol = dfs(n+1, list, ia);
				ia[list.get(n)[0]][list.get(n)[1]] = 0;
				if(bol == 1)return 1;
			}
		}
		
		return 0;
	}
	
	public static boolean backtraking(int[] curr, int[][] ia, int n) {
		
		for(int i=0; i<9; i++ ) {
			if(ia[curr[0]][i] == n) return false;
			if(ia[i][curr[1]] == n) return false;
		}
		for(int i=curr[0]/3*3; i<curr[0]/3*3+3; i++) {
			for(int j=curr[1]/3*3; j<curr[1]/3*3+3; j++) {
				if(ia[i][j]==n) return false;
			}
		}
		return true;
	}
	
}
