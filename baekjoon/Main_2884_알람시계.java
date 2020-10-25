package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2884_알람시계 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int h = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		if(m-45 < 0) {
			if(h-1 < 0) {
				h = 23;
				m += 60-45; 
			}
			else {
				h -= 1;
				m += 60-45; 
			}
		}
		else {
			m -= 45;
		}
		
		System.out.println(h+" "+m);
	}

}
