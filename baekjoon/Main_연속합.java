package baekjoon;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_연속합 {

	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("res/input_day1_1.txt"));
		Scanner sc = new Scanner(System.in);
		
		//int T = sc.nextInt();
		
		//for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int[] A = new int[N];
			
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			if(N>1) {
				for(int i=1; i<N; i++) {
					if(A[i]+A[i-1]>A[i]) {
						A[i] = A[i]+A[i-1];
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				if(A[i]>max) max = A[i];
			}
		
			//System.out.println("#"+tc+" "+max);
			System.out.println(max);
			
		//}
		

	}

}
