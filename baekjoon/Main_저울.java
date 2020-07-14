package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_저울 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = sc.nextInt();
		}
		Arrays.sort(ia);
		int sum = 0;
		for(int i=0; i<N; i++) {
			if(ia[i] <= sum+1) sum += ia[i];
			else break;
		}
		
		System.out.println(sum + 1);
	}

}
