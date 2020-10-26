package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_암호만들기 {
	
	static List<String> list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int C = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		String[] data = new String[C];
		
		list = new ArrayList<>();
		
		comb(N,C,s,data);
		Collections.sort(list);
		
		for(String l:list) System.out.println(l);
		
	}
	
	public static void comb(int n, int c, String[] s, String[] data) {
		if(n<c) return;
		if(c==0) {
			int ja = 0;
			int mo = 0;
			for(String d :data ) {
				if(d.equals("a") || d.equals("e") || d.equals("o") ||  d.equals("u") ||  d.equals("i")  ) mo++;
				else ja++;
			}
			if(mo>=1 && ja>=2) {
				String word = "";
				for(String d:data) word+=d;
				char[] sort = word.toCharArray();
				Arrays.sort(sort);
				word = "";
				for(char ca:sort) word+=ca;
				if(!list.contains(word)) list.add(word);
			}
			
			return;
		}
		data[c-1] = s[n-1];
		comb(n-1,c-1,s,data);
		comb(n-1,c,s,data);
	}

}
