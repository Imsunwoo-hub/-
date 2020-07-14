package swex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_Flatten {
	
	static int[] ia;
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{		
			int N = sc.nextInt();
			ia = new int[100];
			for(int i=0; i<100; i++) {
				ia[i] = sc.nextInt();
			}
			sort(ia);
			while(N>0) {
				sort(ia);
				ia[99]--;
				ia[0]++;
				N--;
			}
			int result = ia[99]-ia[0];
			System.out.println("#"+tc+" "+result);
		}
	}
	static void sort(int[] ia) {
		for(int i=0; i<ia.length-1; i++) {
			for(int j=0; j<ia.length-1-i; j++) {
				if(ia[j]> ia[j+1]) {
					int temp = ia[j];
					ia[j] = ia[j+1];
					ia[j+1] = temp;
				}
			}
		}
	}

}
