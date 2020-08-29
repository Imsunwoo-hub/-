package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_수고르기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int [] ia = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ia);
		
		int result = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		
		while(true) {
			if(end == N) break;
			if(ia[end]-ia[start]<M) {
				end++;
			}
			else {
				if(ia[end]-ia[start]<result) result = ia[end]-ia[start];
				if(start==end) end++;
				else start++;
			}
		}
		
		System.out.println(result);

	}

}
