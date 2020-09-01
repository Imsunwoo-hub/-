package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_최단경로출력 {

public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int INF = Integer.MAX_VALUE;
		int[][] gp = new int[26][26];
	
		int[] d = new int[26];
		int[] v = new int[26];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			gp[s[0].charAt(0)-'A'][s[1].charAt(0)-'A'] = Integer.parseInt(s[2]);
			gp[s[1].charAt(0)-'A'][s[0].charAt(0)-'A'] = Integer.parseInt(s[2]);
		}
		
		s = br.readLine().split(" ");
		int start = s[0].charAt(0)-'A';
		int end =  s[1].charAt(0)-'A';
		
		for(int i=0; i<26; i++)  d[i] = INF;
		
		String[] t = new String[26];
		
		for(int i=0; i<26; i++) t[i] = (char)(i+'A')+"";
		
		d[start] = 0;
		
		
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {start,0});
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]]==1) continue;
			v[curr[0]] = 1;
			
			for(int i=0; i<26; i++) {
				if(gp[curr[0]][i]==0) continue;
				if(d[i] > d[curr[0]] + gp[curr[0]][i]) {
					d[i] = d[curr[0]] + gp[curr[0]][i];
					//System.out.println((char)(curr[0]+'A') +"->"+(char)(i+'A'));
					t[i] = (char)(i+'A')+"";
					t[i] = t[curr[0]]+t[i];
					q.offer(new int[] {i,d[i]});
				}
			}
		}
		
		if(d[end]==INF) System.out.println("-1");
		else {
			System.out.println(d[end]);
			for(int i=0; i<t[end].length(); i++) {
				System.out.println(t[end].charAt(i));
			}
		}
		
	}
}
