package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]); 
		int end = Integer.parseInt(s[1]); 
		
		int[] v = new int[end+2];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1],o2[1]);
			}
		});
		
		q.offer(new int[] {start, 0});
		v[start] = 1;
		
		int result = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==end) {
				result = curr[1];
			}
			
			if(curr[0]-1 >= 0 && v[curr[0]-1]==0) {
				v[curr[0]-1] = 1;
				q.offer(new int[] {curr[0]-1, curr[1]+1});
			}
			
			if(curr[0]+1 < v.length && v[curr[0]+1]==0) {
				v[curr[0]+1] = 1;
				q.offer(new int[] {curr[0]+1, curr[1]+1});
			}
			
			if(curr[0]*2 < v.length && v[curr[0]*2]==0) {
				v[curr[0]*2] = 1;
				q.offer(new int[] {curr[0]*2, curr[1]+1});
			}
			
		}
		
		System.out.println(result);
		
	}

}
