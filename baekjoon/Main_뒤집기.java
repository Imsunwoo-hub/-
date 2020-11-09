package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_뒤집기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int[] cnt = new int[2];
		
		int c = s.charAt(0)-'0';
		cnt[c]++;
		
		for(int i=1; i<s.length(); i++) {
			if(c != s.charAt(i)-'0') {
				c = s.charAt(i)-'0';
				cnt[c]++;
			}
		}
		
		
		
		System.out.println(Math.min(cnt[0], cnt[1]));

	}

}
