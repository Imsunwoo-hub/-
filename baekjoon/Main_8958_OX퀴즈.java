package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			int cnt = 0;
			int result = 0;
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='O') {
					cnt++;
					result+=cnt;
				}
				else cnt = 0;
			}
			System.out.println(result);
		}

	}

}
