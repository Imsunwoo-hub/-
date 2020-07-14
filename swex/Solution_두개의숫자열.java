package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_두개의숫자열 {
 
    	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d2_1959.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{	
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] ia1 = new int[N];
			int[] ia2 = new int[M];
			for(int i=0; i<ia1.length; i++) {
				ia1[i] = sc.nextInt();
			}
			for(int i=0; i<ia2.length; i++) {
				ia2[i] = sc.nextInt();
			}
			int max = Integer.MIN_VALUE;
			int start = 0;
			int big = ia1.length>ia2.length ? ia1.length : ia2.length;
			int small = ia1.length<ia2.length ? ia1.length : ia2.length;
		
			while(start+small<=big) {
				int temp = 0;
				for(int i=0; i<small; i++ ) {
					if(ia1.length==small) {
						temp += ia1[i] * ia2[i+start];
					}	
					if(ia2.length==small) {
						temp += ia1[i+start] * ia2[i];
					}
				}
				if(temp>max) max = temp;
				start++;
			}
			System.out.println("#"+tc+" " + max);
		}
	}
}
