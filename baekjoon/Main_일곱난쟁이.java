package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_일곱난쟁이{
	
	static int[] ia, data;
	static int bol;

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		ia  = new int[9];
		data = new int[7];
		for(int i=0; i<9; i++) {
			ia[i] = sc.nextInt();
		}
		
		comb(9,7);

	}
	
	static void comb(int n, int c) {
		if(n<c) return;
		if(bol==1) return;
		if(c==0) {
			
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += data[i];
			}
			if(sum==100) {
				bol = 1;
				Arrays.sort(data);
				for(int i=0; i<7; i++) {
					System.out.println(data[i]);
				}
			}
			
			return;
		}
		data[c-1] = ia[n-1];
		comb(n-1, c-1);
		comb(n-1, c);
	}

}
