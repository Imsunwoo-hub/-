package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_부분합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]); 
		}
		
		int result = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		int end = 0;
		
		while(true) {
			if(sum >= K) {
				if(end-start < result) result = end-start;
				sum -= ia[start++];
			}
			else if(end==N) break;
			else sum += ia[end++];
		}
		if(result == Integer.MAX_VALUE) result = 0;
		System.out.println(result);

	}

}
