package swex;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_계산기3 {

	public static void main(String[] args) throws Exception {
		
		
		System.setIn(new FileInputStream("res/input_d4_1224.txt"));
		Scanner sc = new Scanner(System.in);
		
		//int T = sc.nextInt();
	
		for(int tc = 1; tc <= 10; tc++)
			
		{	
			int N = sc.nextInt();
			String s = sc.next();
			
			String temp = postfix(s);
			int result = calc(temp);
			
			System.out.println("#" + tc+" "+result);
		}

	}
	
	public static String postfix(String m) {
		
		String msg = m;
		Stack<Character> s = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
				
		for(int i=0; i<msg.length(); i++) {
			char c = msg.charAt(i);
			if(c==' ') continue;
			if(c=='(') s.push(c);
			else if(c=='+') {
				while(true) {
					if(s.size()==0 ||  s.peek()=='(') {
						s.push(c);
						break;
					}
					else { 
						char t = s.pop();
						sb.append(t);
					}
				}
			}
			else if(c=='*') {
				while(true) {
					if(s.size()==0 || s.peek() == '(' || s.peek() == '+') {
						s.push(c);
						break;
					}
					else {
						char t = s.pop();
						sb.append(t);
					}
				}
			}
			else if(c==')') {
				while(true) {
					if( s.size() !=0 && s.peek()=='(') {
						s.pop();
						break;
					}
					else {
						char t = s.pop();
						sb.append(t);
					}
				}
			}
				
			else sb.append(c);
		}
		if(!s.isEmpty()) {
			while(!s.isEmpty()) {
				char c = s.pop();
				sb.append(c);
			}
		}
		
		return sb.toString();
		
	}
	
public static int calc(String str) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		
		for(int i=0; i<str.length(); i++) {
			int a = 0;
			int b = 0;
			int r = 0;
			char c = str.charAt(i);
			if(c=='+') {
				b =  s1.pop();
				a =  s1.pop();
				r = a+b;
				s1.push(r);
			}
			
			else if(c=='*') {
				 b =  s1.pop();
				 a =  s1.pop();
				 r = a*b;
				s1.push(r);
			}
			else {
				s1.push( c-'0');
			}
		}
		int i = s1.pop();
		return i;
	}

}
