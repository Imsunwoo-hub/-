package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_스타트와링크1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int F = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		int G = Integer.parseInt(s[2]);
		int U = Integer.parseInt(s[3]);
		int D = Integer.parseInt(s[4]);
		
		int[] v = new int[F+1];
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		q.offer(new int[] {S,0});
		v[S] = 1;
		int result =-1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(curr[0]==G) {
				result = curr[1];
				break;
			}
			if(curr[0]+U <= F && v[curr[0]+U]==0 ) {
				v[curr[0]+U]=1;
				q.offer(new int[] {curr[0]+U, curr[1]+1});
			}
			if(curr[0]-D > 0 && v[curr[0]-D]==0) {
				v[curr[0]-D]=1;
				q.offer(new int[] {curr[0]-D, curr[1]+1});
			}
			
		}
		if(result == -1) System.out.println("use the stairs");
		else System.out.println(result);

	}

}
