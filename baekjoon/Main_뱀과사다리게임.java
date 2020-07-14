package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_뱀과사다리게임 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] ia = new int[101];
		int[] v = new int[101];
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		for(int i=1; i<101; i++) {
			ia[i] = i;
		}
		
		for(int i=0 ; i<N+M; i++) {
			String[] t = br.readLine().split(" ");
			int a = Integer.parseInt(t[0]);
			int b = Integer.parseInt(t[1]);
			ia[a] = b;
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[1], o2[1]);
				if(r==0) r = -Integer.compare(o1[0], o2[0]);
				return r;
			}
		}); 
		
		q.offer(new int[] {1,0});
		
		int result = 0 ;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			//System.out.println(curr[0]+", "+ curr[1]);
			
			if(curr[0] == 100) {
				result = curr[1];
				break;
			}
			if(v[curr[0]]==0) {
				
				v[curr[0]]= 1;
				
				for(int i=1; i<7; i++) {
					if(curr[0]+i <= 100) {
						q.offer(new int[] {ia[curr[0]+i], curr[1]+1});
					}
				}
			}
			
		}
		
		System.out.println(result);
	}

}
