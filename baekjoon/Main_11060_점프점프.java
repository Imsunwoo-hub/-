package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11060_점프점프 {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] ia = new int[N];
		int[] v = new int[N];
		
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		q.offer(new int[] {0,0});
		v[0] = 1;
		int result = -1;
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			if(curr[0]==N-1) {
				System.out.println(curr[1]);
				return;
			}
			for(int i=0; i<=ia[curr[0]]; i++) {
				int ni = curr[0]+i;
				if(ni<N && v[ni]==0) {
					v[ni] = 1;
					q.offer(new int[] {ni,curr[1]+1});
				}
			}
		}
		System.out.println(result);
	}

}
