package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_괄호의값 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int temp = 1;
		int bol = 0;
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
                    temp *= 2;
                    stack.push('(');
            }
			else if (s.charAt(i) == '['){
                    temp *= 3;
                    stack.push('[');

            }

            else if (s.charAt(i) == ')' && (stack.isEmpty() || stack.peek() != '(')){
                    bol = 1;
                    break;

            }

            else if (s.charAt(i) == ']' && (stack.isEmpty() || stack.peek() != '[')){
                    bol = 1;
                    break;
            }

            else if (s.charAt(i) == ')')

            {

                    if (s.charAt(i-1) == '(') result += temp;

                    stack.pop();

                    temp /= 2;

            }

            else if (s.charAt(i) == ']'){
                    if (s.charAt(i-1) == '[')result += temp;
                    stack.pop();
                    temp /= 3;
            }
		}
		
		if(bol==1 || !stack.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(result);	
			
		}
	}
	
}
