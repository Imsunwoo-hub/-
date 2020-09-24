package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int bol = 0;
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			bol = 0;
			char c = s.charAt(0);
			int[] ia = new int[26];
			ia[c-97] = 1;
			for(int j=1; j<s.length(); j++) {
				if(c!=s.charAt(j)) {
					if(ia[s.charAt(j)-97]!=0) {
						bol = 1;
						break;
					}
					c = s.charAt(j);
					ia[c-97] = 1;
				}
			}
			if(bol == 0) result++;
		}
		
		System.out.println(result);
	}

}
