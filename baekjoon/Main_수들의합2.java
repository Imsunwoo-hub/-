package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_수들의합2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		
		int[] ia = new int[N];
		s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		
		int result = 0;
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		while(true) {
			if(sum>=K) sum-=ia[start++];
			else if(end==N) break;
			else sum+=ia[end++];
			if(sum==K) result++;
		}
		
		System.out.println(result);
		

	}

}
