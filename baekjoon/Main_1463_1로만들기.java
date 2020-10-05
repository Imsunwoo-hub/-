package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1463_1로만들기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] v = new int[N+1]; 
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
			
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {N, 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0]==1) {
				System.out.println(curr[1]);
				return;
			}
			
			if(curr[0]%3==0 && v[curr[0]/3]==0) {
				v[curr[0]/3]=1;
				q.offer(new int[] {curr[0]/3, curr[1]+1});
			}
			if(curr[0]%2==0 && v[curr[0]/2]==0){
				v[curr[0]/2]=1;
				q.offer(new int[] {curr[0]/2, curr[1]+1});
			}
			
			if(v[curr[0]-1]==0) {
				v[curr[0]-1]=1;
				q.offer(new int[] {curr[0]-1, curr[1]+1});
			}
		}

	}

}
