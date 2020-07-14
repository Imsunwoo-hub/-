package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_30 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String result = "";
		long sum = 0;
		int bol = 0;
		int[] counta = new int[10];
		
		for(int i=0; i<s.length(); i++) {
			int a = s.charAt(i)-'0';
			if(a==0) bol = 1;
			sum += a;
			counta[a]++;
		}
		if(bol==0 || sum%3!=0) {
			System.out.println("-1");
			return;
		}
		else {
			 StringBuilder sb = new StringBuilder();
		        for(int i = 9; i >= 0; i--) {
		            while(counta[i] > 0) {
		                sb.append(i);
		                counta[i]--;
		            }
		        }
		        System.out.println(sb.toString());
		    }	
		}
		
	}
