package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_경로구하기 {
	
	static int N, K;
	static int[][] ia;
	static int[] v;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		
		ia = new int[N][K];
		v = new int[N];
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<K; j++) {
				ia[i][j] = t.charAt(j)-'0';
			}
		}
		
		s = br.readLine().split(" ");
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		
		String result = "";
		
		
		PriorityQueue<String[]> q = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.compare(o1[1].length(), o2[1].length());
			}
		});
		
		q.offer(new String[] {(a-1)+"", (a-1)+" "});
		
		while(!q.isEmpty()) {
			String[] curr = q.poll();
			int c = Integer.parseInt(curr[0]);
		
			if(v[c]==0) {
				v[c] = 1;
				
				if(c+1==b) {
					result = curr[1];
					break;
				}
				
				for(int i=0; i<N; i++) {
					if(i==c || v[i]==1) continue;
					int cnt = 0;
					for(int j=0; j<K; j++) {
						if(ia[i][j] != ia[c][j]) cnt++;
					}
					if(cnt==1) { 
						q.offer(new String[] {i+"", curr[1]+(i+" ")});
					}
				}
				
			}
		}
		
		if(v[b-1]==0) System.out.println("-1");
		else {
			s = result.split(" ");
			for(int i=0; i<s.length; i++) System.out.print(Integer.parseInt(s[i])+1+" ");
		}
		
	}
}
