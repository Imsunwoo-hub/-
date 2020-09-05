package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_0은빼 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int[] ia = new int[k+1];
		int top = -1;
		
		for(int i=0; i<k; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a==0) {
				top--;
				if(top < -1) top = -1;
			}
			else {
				ia[++top] = a;
			}
			
		}
		
		int sum = 0;
		
		for(int i=top; i>=0; i--) {
			sum += ia[i];
		}
		
		System.out.println(sum);
	}

}
