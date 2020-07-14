package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_단어공부 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		
		int[] count = new int[26];
		int[] max = new int[26];
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			count[c-65]++; 
			max[c-65]++;
		}
		Arrays.sort(max);
		int c = max[max.length-1];
		char result = 0;
		int bol = 0;
		for(int i=0; i<count.length; i++) {
			if(count[i]!=0 && bol==0 &&  count[i] == c) {
				bol=1;
				result = (char)(i+65);
				continue;
			}
			if(count[i]!=0 && bol==1 && count[i]==c) {
				result='?';
				break;
			}
		}
		System.out.println(result);
		
	}

}
