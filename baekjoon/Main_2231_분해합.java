package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231_분해합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			String s = i+"";
			int temp = i;
			for(int j=0; j<s.length(); j++) {
				temp += s.charAt(j)-'0';
			}
			if(temp==N) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}
