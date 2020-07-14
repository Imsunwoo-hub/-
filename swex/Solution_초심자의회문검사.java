package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_초심자의회문검사 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d2_1989.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			String s = sc.next();
			int result = ok(s);
			System.out.println("#" + tc+ " "+ result);
		}
	}
	
	public static int ok(String s) {
		int ok = 1;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) !=s.charAt(s.length()-1-i)) {
				ok=0;
				break;
			}
		}
		return ok;
	}
}


