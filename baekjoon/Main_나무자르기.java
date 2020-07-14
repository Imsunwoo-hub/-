package baekjoon;

import java.util.Scanner;

public class Main_나무자르기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = sc.nextInt();
		}
		int result = 0;
		int l = 0;
		int r = 1000000000;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				int a = ia[i] - mid;
				if(a > 0) sum += a;
			}
			
			if(sum < M) {
				r = mid-1;
			}
			
			else {
				result = mid;
				l = mid+1;
			}
			
		}
		System.out.println(result);	
	}

}
