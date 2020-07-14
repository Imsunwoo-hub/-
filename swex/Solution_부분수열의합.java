package swex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_부분수열의합 {
	
	/*public static int hap;
	public static int cnt=0;
	public static int N;
	public static int[] data;
	
	public static void solve(int sum, int pos) {
		if(sum>hap) return;
		if(sum==hap) {
			cnt++;
			return;
		}
		if(pos>N-1) return;
		solve(sum, pos+1);
		solve(sum+data[pos],pos+1);
	}*/
	

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_2817.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{	
			int N = sc.nextInt();
			int k = sc.nextInt();
			
			int[] ia = new int[N];
			for(int i=0; i<ia.length; i++) {
				ia[i] = sc.nextInt();
			}
			
			int count = 0;
			for(int i=0; i<(1<<N); i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					if((i & (1<<j))> 0) {
						
						sum += ia[j];
					}
				}
				if(sum == k) count++;
			}
			System.out.println("#"+ tc+" " + count);
		}

	}

}
