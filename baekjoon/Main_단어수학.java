package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main_단어수학 {
	
	static int[] doc;
	static String[] sa;
	static int result, N;

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		sa = new String[N];
		doc = new int[26];
	
		
		for(int i=0; i<N; i++) {
			String s =  br.readLine();
			sa[i] = s;
			int idx =(int) Math.pow(10, s.length()-1);
			for(int j=0; j<s.length(); j++) {
				doc[s.charAt(j)-'A'] += idx;
				idx/=10;
			}
		}
		Arrays.sort(doc);
		int num = 9;
		result = 0;
		for(int i=doc.length-1; i>=0; i--) {
			if(num==0) break;
			result += doc[i]*num--;
		}
		
	
		System.out.println(result);

	}
	
}
