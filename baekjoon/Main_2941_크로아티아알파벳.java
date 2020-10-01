package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int result = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='c') {
				if(i<s.length()-1) {
					char next = s.charAt(i+1);
					if(next=='='|| next=='-') i++;
				}
			}
			else if(c=='d') {
				if(i<s.length()-2) {
					if(s.charAt(i+1)=='z' && s.charAt(i+2)=='=') i+=2;
				}
				if(i<s.length()-1) {
					if(s.charAt(i+1)=='-') i++;
				}
			}
			else if(c=='s'|| c=='z') {
				if(i<s.length()-1) {
					if(s.charAt(i+1)=='=') i++;
				}
			}
			else if(c=='l' || c=='n') {
				if(i<s.length()-1) {
					if(s.charAt(i+1)=='j') i++;
				}
			}
			result++;
		}
		
		System.out.println(result);
		
	}

}
