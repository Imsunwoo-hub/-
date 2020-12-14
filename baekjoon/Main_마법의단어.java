package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_마법의단어 {
	
	static int result, K;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = new String[N];
		
		for(int i=0; i<N; i++) {
			s[i] = br.readLine();
		}
		
		K = Integer.parseInt(br.readLine());
		
		result = 0;
		
		dfs(0,s);
		System.out.println(result);

	}
	
	public static void dfs(int i, String[] s) {
		if(i==s.length) {
			String p = "";
			
			for(int j=0; j<s.length; j++) {
				p += s[j];
			}
			String word = p.concat(p.substring(0,p.length()-1));
			
			if(kmp(word,p)==K) result++;
			
			return;
		}
		
		for(int j=i; j<s.length; j++) {
			swap(i,j,s);
			dfs(i+1,s);
			swap(i,j,s);
		}
	}
	
	public static void swap(int i,int j, String[] s) {
		if(i==j) return;
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	public static int kmp(String s, String p) {
		int cnt = 0;
		
		int[] pi = getPi(p);
		
		int j=0;
		
		for(int i=0; i<s.length(); i++) {
			while(j>0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(j==p.length()-1) {
				cnt++;
				j = pi[j];
			}
			else j++;
		}
		
		return cnt;
	}
	
	public static int[] getPi(String p) {
		int[] pi = new int[p.length()]; 
		
		int j=0;
		
		for(int i=1; i<p.length(); i++) {
			while(j>0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

}
