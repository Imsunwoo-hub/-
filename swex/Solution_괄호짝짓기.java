package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
	
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		Scanner sc = new Scanner(System.in);
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			int N = sc.nextInt();
			int idx = 0;
			char[] c = new char[N];
			String s = sc.next();
			int result = 1;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='<') {
					c[idx++] = s.charAt(i);
				}
				else {
					if(s.charAt(i)==')') {
						if(c[idx-1]=='(') {
							idx--;
						}
						else {
							result = 0;
							break;
						}
					}
					else if(s.charAt(i)=='}') {
						if(c[idx-1]=='{') {
							idx--;
						}
						else {
							result = 0;
							break;
						}
					}
					else if(s.charAt(i)==']') {
						if(c[idx-1]=='[') {
							idx--;
						}
						else {
							result = 0;
							break;
						}
					}
					else {
						if(c[idx-1]=='<') {
							idx--;
						}
						else {
							result = 0;
							break;
						}
					}
				}
				
			}
		
			System.out.println("#"+tc+" " + result);
		
		}

	}

}
