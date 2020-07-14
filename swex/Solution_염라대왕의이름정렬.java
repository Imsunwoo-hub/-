package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_염라대왕의이름정렬 {
	
	public static List<String> a, ra;
	public static Set<String> s;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_7701.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			s = new HashSet<>();
			for(int i=0; i<N; i++) {
				s.add(br.readLine()); 
			}
			a = new ArrayList<>();
			ra = new ArrayList<>();
			for(String w:s) {
				a.add(w);
				ra.add(null);
			}
		
			mergesort(0, a.size()-1);
			
			System.out.println("#"+ tc);
			for(String w:a)System.out.println(w);
			
		}
	}
	public static void mergesort(int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergesort(left,mid);
			mergesort(mid+1, right);
			merge(left,mid,right);
		}
	}
	
	public static void merge(int left, int mid, int right) {
		
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i<=mid && j<=right) {
			if(a.get(i).length()<a.get(j).length()) ra.set(k++, a.get(i++));
			
			else if(a.get(i).length()==a.get(j).length()) {
				for(int l=0; l<a.get(i).length(); l++) {
					 if(a.get(i).charAt(l) != a.get(j).charAt(l)) {
						 ra.set(k++, a.get(i).charAt(l) > a.get(j).charAt(l)? a.get(j++) : a.get(i++));
						 break;
					 }
				}
			}
			else ra.set(k++, a.get(j++));
		}
		if(i>mid) {
			for(int l=j; l<=right; l++) {
				ra.set(k++, a.get(l));
				
			}
		}else {
			for(int l=i; l<=mid; l++) {
				ra.set(k++, a.get(l));
			
			}
		}
		for(int l=left; l<=right; l++) {
			a.set(l, ra.get(l));
		
		}
	}
	
	 
}
