package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_보석도둑 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[][] ia = new int[N][2];
		int[] ka = new int[K];
	
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(s[0]);
			ia[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int i=0; i<K; i++) {
			ka[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ka);
		Arrays.sort(ia, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				return r;
			}
		});
		
		int idx = 0;
		int result = 0;
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});
		
		for(int i=0; i<K; i++) {
			while(idx<N && ia[idx][0] <= ka[i]) {
				q.offer(ia[idx++][1]);
			}
			if(!q.isEmpty()) {
				result += q.poll();
			}
		}
		
		System.out.println(result);
		
	}

}
