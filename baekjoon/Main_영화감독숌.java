package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_영화감독숌 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i=666; N>0; i++) {
			String s = i+"";
			if(s.contains("666")) {
				N--;
				result = i;
			}
		}

		System.out.println(result);
	}

}
