package baekjoon;

import java.util.Scanner;

public class Main_동전0 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = sc.nextInt();
		}
		
		int result = 0;
		for(int i=N-1; i>=0; i-- ) {
			int a = K/ia[i];
			if(a==0) continue;
			else {
				result += a;
				K = K%ia[i];
			}
		}
		
		System.out.println(result);

	}

}
