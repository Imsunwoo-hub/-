package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_NQueen {
	
	public static int[] col; 
	public static int N,result;

	public static void main(String[] args) throws Exception {
	
		System.setIn(new FileInputStream("res/input_d3_2806.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{	
			N = sc.nextInt();
			col= new int[N];
			result = 0;
			nqueen(0);
		
			System.out.println("#"+tc+" " + result);
		}	
	}
	
	public static void nqueen(int i) {
		if(i==N) {
			result++;
			return;
		}
		for(int j=0; j<N; j++) {
			col[i] = j;
			if(promis(i)) {
				nqueen(i+1);
			}
		}
		
	}
	
	public static boolean promis(int i) {
		for(int j=0; j<i; j++) {
			if(col[i]==col[j] || Math.abs(col[i]-col[j]) == i-j) return false;
		}
		
		return true;
	}

}
