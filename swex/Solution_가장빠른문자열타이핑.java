package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_가장빠른문자열타이핑 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_3143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] sa = br.readLine().split(" ");
			String A = sa[0];
			String B = sa[1];
			int count = A.length(); 
			int bl = B.length();
			int start = 0;
			lable: while(start<=A.length()-bl) {
				
				for(int i=start; i<=A.length()-bl; i++) {
					String temp = "";
					for(int j=i; j<i+bl; j++) {
						temp += A.charAt(j);
					}
					if(temp.equals(B)) {
						count -= bl-1;
						start = i+bl;
						continue lable;
					}
				}
				start++;
			}
			
			System.out.println("#"+tc+" "+count);
		}

	}

}
