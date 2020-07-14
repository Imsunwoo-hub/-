package baekjoon;

import java.util.Scanner;

public class Main_토마토 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] ia = {500,100,50,10,5,1};
		
		int result = 0;
		N = 1000 - N;
		for(int i=0; i<6; i++) {
			int a = N/ia[i];
			if(a==0) continue;
			else {
				result += a;
				N = N%ia[i];
			}
		}
		
		System.out.println(result);
	}

}
