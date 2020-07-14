package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_String {

	public static void main(String[] args) throws Exception {
		
		
		System.setIn(new FileInputStream("res/input_d3_1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10;tc++) {
			
			int T = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String s = br.readLine();
			int count =0;
			int wl = word.length();
			for(int i=0; i<=s.length()-wl; i++) {
				String t = "";
				for(int j=i; j<i+wl; j++) {
					t += s.charAt(j);
				}
				if(t.equals(word)) count++;
			}
			
			
			System.out.println("#"+T+" "+ count);
			
		}

	}

}
