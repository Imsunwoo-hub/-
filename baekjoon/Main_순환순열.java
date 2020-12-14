package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_순환순열 {
	
	static int result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		B = B.concat(B.substring(0,B.length()-1));
		
		result = 0;
		
		kmp(B,A);
		
		System.out.println(result);

	}
	
	public static void kmp(String s, String p) {
		int[] pi = getPi(p);
		int j=0;
		for(int i=0; i<s.length(); i++) {
			while(j>0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(j == p.length()-1) {
				result++;
				j = pi[j];
			}
			else {
				j++;
			}
		}
		
	}
	
	public static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		
		int j=0;
		
		for(int i=1; i<p.length(); i++) {
			
			while( j>0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i)==p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

}
