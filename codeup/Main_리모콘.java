package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_리모콘 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		int result = 0;
		while(start != end) {
			
			if(start < end) {
				int one = start + 1;
				int five = start + 5;
				int ten = start + 10;
				if(Math.abs(one-end) < Math.abs(five-end)) {
					if(Math.abs(one-end) < Math.abs(ten-end)) start = one;
					else start = ten;
				}
				else {
					if(Math.abs(five-end)< Math.abs(ten-end)) start = five;
					else start = ten;
				}
			}
			else {
				int one = start -1;
				int five = start -5;
				int ten = start -10;
				if(Math.abs(one-end) < Math.abs(five-end)) {
					if(Math.abs(one-end) < Math.abs(ten-end)) start = one;
					else start = ten;
				}
				else {
					if(Math.abs(five-end)< Math.abs(ten-end)) start = five;
					else start = ten;
				}
			}
			result++;
		}
		
		System.out.println(result);
	}

}
