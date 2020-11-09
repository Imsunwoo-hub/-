package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main_후위표기식 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		char[] ca = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<ca.length; i++) {
			int p = getP(ca[i]);
			char c = ca[i];
			if(c=='*'|| c=='/'|| c=='-'|| c=='+') {
				while(!stack.isEmpty() && getP(stack.peek()) >= p) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
			else if(c=='(') {
				stack.push(c);
			}
			else if(c==')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}
			else sb.append(c);
			
		}
		
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb.toString());
		
	}
	
	public static int getP(char c) {
		if(c=='*' ||  c=='/') return 2;
		else if(c=='+' || c=='-') return 1;
		else if(c=='(' || c==')') return 0;
		return -1;
	}
}
