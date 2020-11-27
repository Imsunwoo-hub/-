package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_컵홀더 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		String temp = "*";
		int bol = 0;
		for(int i=0; i<N; i++) {
			if(s.charAt(i)=='S') {
				temp+="S*";
			}
			else {
				if(bol==0) {
					bol = 1;
					temp += "L";
				}
				else {
					bol = 0;
					temp += "L*";
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<temp.length(); i++) {
			if(temp.charAt(i)=='*') result++;
		}
		if(result > N) System.out.println(N);
		else System.out.println(result);
	}

}
