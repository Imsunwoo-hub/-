package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_거듭제곱 {
	
	

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		Scanner sc = new Scanner(System.in);
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			int T = sc.nextInt();
			
			
			int n = sc.nextInt();
			int m = sc.nextInt();
		
			
			int r = run(n,m);
			
		
			System.out.println("#"+T+" "+r);
		}

	}
	
	public static int run(int n, int m) {
		// 분할정복
		if(m==1) return n;
		if((m&1)==0) {
			int y = run(n,m/2);
			return y*y;
		}
		else {
			int y = run(n,(m-1)/2);
			return y*y*n;
		}
		
		/*if(m==0) return 1;
		if(m==1) return n;
		return n * run(n, m-1);*/
		
	}

}
