package swex;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_암호생성기 {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		Scanner sc = new Scanner(System.in);
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			int T = sc.nextInt();
			int[] ia = new int[8];
			int[] a = {1,2,3,4,5};
			for(int i=0;i<8; i++) {
				ia[i] = sc.nextInt();
			}
			int c = 0;
			exit:while(true) {
				for(int i=0; i<5; i++) {
					ia[c%8] -= a[i];
					if(ia[c%8] <= 0) {
						ia[c%8] = 0;
						break exit;
					}
					c++;
				}
			}
			System.out.print("#"+T+" ");
			for(int i=0; i<8; i++) {
				System.out.print(ia[++c%8]+" ");
			}
			System.out.println();
		}
	}
}
