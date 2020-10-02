package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();
		
		List<Integer> result = KMP(T,P);
		
		System.out.println(result.size());
		for(int i:result) System.out.print(i+1+" ");
		
	}
	
	public static ArrayList<Integer> KMP(String t, String p) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] pi = getPi(p);
		int n = t.length();
		int m = p.length();
		int j = 0;
		for(int i=0; i<n; i++) {
			while(j>0 && t.charAt(i)!= p.charAt(j)) j = pi[j-1];
			if(t.charAt(i) == p.charAt(j)) {
				if(j == m-1) {
					list.add(i-m+1);
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
		return list;
	}
	
	public static int[] getPi(String p) {
		int[] pi = new int[p.length()];
		int j=0;
		for(int i=1; i<p.length(); i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

}
