package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_최대상금 {
	
	public static char[] ca;
	public static int n,c,result;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] sa = br.readLine().split(" ");
			ca = sa[0].toCharArray();
			n = ca.length;
			c = Integer.parseInt(sa[1]);
			result = 0;
			permutation(0,0);
			System.out.println("#"+ tc+" " + result );
		}
	}

	private static void permutation(int cur, int count) {
		if(count==c) {
			int r =  Integer.parseInt(String.valueOf(ca));
			result = result > r ? result:r;  
			return;
		}
		for(int i=cur; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(ca[i]<=ca[j]) {
				swap(i,j);
				permutation(i, count+1);
				swap(i,j);
				}
			}
		}
	}
	private static void swap(int i, int j) {
		char t = ca[i];
		ca[i] = ca[j];
		ca[j] = t;
	}
	
}
