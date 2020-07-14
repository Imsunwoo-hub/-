package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_반장선출 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_7792.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] sa = new String[N];
			for(int i=0; i<N; i++) {
				sa[i] = br.readLine();
			}
			Arrays.sort(sa);
			String s = "";
			int max = 0;
			int idx = 0;
			for(int i=0; i<N; i++) {
				String t = sa[i];
				s="";
				int start = 1;
				if(t.charAt(0)==' ') {
					start = 2;
					s += t.charAt(1); 
				}
				else {
					s += t.charAt(0);
				}
				for(int j=start; j<t.length(); j++) {
					if(t.charAt(j) != ' ' &&  (t.charAt(j)<'A' || t.charAt(j)>'Z')) continue;
					int bol = 0;
					for(int k=0; k<s.length(); k++) {
						if(t.charAt(j) == s.charAt(k) || (j==t.length()-1 && t.charAt(j)==' ' )) {
							bol = 1;
							break;
						}
					}
					if(bol==0) {
						s += t.charAt(j);
					}
				}
				if(s.length() > max) {
					max = s.length();
					idx = i;
				}
			}
			String result = sa[idx];
			System.out.println("#"+tc+" " + result);
		}
			
	}

}
