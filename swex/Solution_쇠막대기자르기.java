package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_쇠막대기자르기 {

	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_5432.txt"));
		sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for(int tc = 1; tc <= T; tc++)
		{	
			String s = sc.next();
			int count = 0;
			int temp = 0;
			int c = 0;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='(') {
					c=0;
					temp++;
				}
				else if(s.charAt(i)==')' && c==0) {
					c=1;
					temp -= 1;
					count += temp;
				}
				else if(s.charAt(i)==')' && c==1) {
					temp -=1;
					count++;
				}
			}
			System.out.println("#"+tc+" " +count );
		}
	}
}
