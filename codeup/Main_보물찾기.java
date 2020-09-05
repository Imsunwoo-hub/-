package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_보물찾기 {

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
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int result = 0;
		
		while(end < N) {
			
			if(sum < K) {
				sum += ia[end++];
				if(sum==K) result++;
			}
			else {
				sum -= ia[start++];
				if(sum==K) result++;
			}
		}
		
		
		System.out.println(result);

	}

}
