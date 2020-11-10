package goorm;

import java.io.*;
import java.util.*;
public class Main_배드민턴경기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int[] china = new int[s.length];
		for(int i=0; i<s.length; i++){
			china[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		int[] korea = new int[s.length];
		for(int i=0; i<s.length; i++){
			korea[i] = Integer.parseInt(s[i]); 
		}
		Arrays.sort(china);
		Arrays.sort(korea);
		
		int cnt = 0;
		int idx = 0;
		
		for(int i=0; i<china.length; i++){
			int c = china[i];
			for(; idx<korea.length; idx++){
				if(korea[idx] >= c){
					cnt++;
					idx++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}