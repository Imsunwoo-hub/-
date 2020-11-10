package goorm;

import java.io.*;
import java.util.*;

public class Main_다익스트라알고리즘 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int INF = Integer.MAX_VALUE;
		
		int[][] gp = new int[N+1][N+1];
		
		for(int i=0; i<M; i++){
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int v = Integer.parseInt(s[2]);
			if(gp[a][b]==0) {
				gp[a][b] = v;
				gp[b][a] = v;
			}
			else {
				if(gp[a][b] > v){
					gp[a][b] = v;
					gp[b][a] = v;
				}
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int start = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		int[] v = new int[N+1];
		for(int i=1; i<=N; i++) d[i] = INF;
		d[start] = 0;
		q.offer(new int []{start, 0} );
		
		while(!q.isEmpty()){
			int[] curr = q.poll();
			if(v[curr[0]]==1) continue;
			v[curr[0]] = 1;
			
			for(int i=1; i<=N; i++){
				if(gp[curr[0]][i]==0) continue;
				if(d[i] > d[curr[0]]+ gp[curr[0]][i]) {
					d[i] = d[curr[0]]+ gp[curr[0]][i];
					q.offer(new int[] {i,d[i]});
				}
			}
		}
		for(int i=1; i<=N; i++){
			System.out.println(i+": "+d[i]);
		}
	}
}