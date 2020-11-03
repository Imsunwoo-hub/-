package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_제로 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
  		long result = 0;
		
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				result -= stack.peek();
				stack.pop();
			}
			else {
				result += n;
				stack.push(n);
			}
		}
		
		System.out.println(result);
		
	}

}
