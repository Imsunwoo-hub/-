package swex;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_원재의메모리복구하기 {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{	
			int count = 0;
			String a = sc.next();
			System.out.println(a);
			String temp = "";
			
			for(int j = 0; j<a.length(); j++) {
				temp += "0";
			}
			System.out.println(temp);
			int start = 0;
			while(true) {
				if(a.equals(temp)) {
					break;
				}

				if(a.charAt(start)==temp.charAt(start)) {
					start += 1;
				}
				else {
					count++;
					String t =""; 
					for(int k=0; k<=start; k++) {
						t += a.charAt(k);
					}
					for(int j=start+1; j<temp.length(); j++) {
						t += a.charAt(start);  
					}
					temp = t;
					System.out.println(temp);
				}
			}
			System.out.println("#"+ tc + " "+ count);
		}
	}
}

