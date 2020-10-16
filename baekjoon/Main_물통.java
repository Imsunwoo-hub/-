package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_물통 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int C = Integer.parseInt(s[2]);
		int[][][] v = new int[A+1][B+1][C+1];
		
		Set<Integer> set = new HashSet<>();
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,C});

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int a = curr[0];
			int b = curr[1];
			int c = curr[2];
			
			if(v[a][b][c]==1) continue;
			v[a][b][c]=1;
			System.out.println(a+" "+b+" "+c);
			if(a==0) {
				set.add(c);
			}
			
			if(a+b>B) q.offer(new int[] {a+b-B, B, c}); 
			else q.offer(new int[] {0, a+b, c});
			
			if(a+c>C) q.offer(new int[] {a+c-C, b, C}); 
			else q.offer(new int[] {0, b, a+c});
			
			if(b+a>A) q.offer(new int[] {A, a+b-A, c}); 
			else q.offer(new int[] {a+b, 0, c});
			
			if(b+c>C) q.offer(new int[] {a, a+b-C, C}); 
			else q.offer(new int[] {a, 0, b+c});
			
			if(b+c>B) q.offer(new int[] {a, B, b+c-B}); 
			else q.offer(new int[] {a, b+c, 0});
			
			if(c+a>A) q.offer(new int[] {A, b, c+a-A}); 
			else q.offer(new int[] {a+c, b, 0});
		}
		
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i:set) result.add(i);
		
		Collections.sort(result);
		
		for(int r:result) System.out.print(r+" ");
	}

}
