package swex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_민석이의과제체크하기 {
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{	
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] ia = new int[K];
			//int[] nia = new int[N-K];
			for(int i=0; i<ia.length; i++) {
				ia[i] = sc.nextInt();
			}
			for(int i=0; i<ia.length-1; i++) {
				for(int j=0; j<ia.length-1-i; j++) {
					if(ia[j]>ia[j+1]) {
						int temp = ia[j];
						ia[j] = ia[j+1];
						ia[j+1] = temp;
					}
				}
			}
		
			System.out.print("#"+ tc + " ");
			for(int i=1; i<=N; i++) {
				int t = 0; 
				for(int j=0; j<ia.length; j++) {
					if(i==ia[j]) {
						t = 1;
						break;
					}
				
				}
				if(t==0) {
					System.out.print(i+ " ");
				}
			}
			System.out.print("\n");
		}
	}

}
