package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_부분수열의합 {

	static int count;
	static int[] ia, temp;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		ia = new int[N];
		temp = new int[N];
		s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		count = 0;
		powerSet(0, K);
		System.out.println(count);
	}
	
	
	public static void powerSet(int i, int K) {
		if(i == ia.length) {
			int sum = 0;
			int cnt = 0;
			for(int j=0; j<temp.length; j++) {
				if(temp[j]==1) {
					cnt++;
					sum += ia[j];
				}
			}
			if(cnt != 0 && sum == K) count++;
			return;
		}
		temp[i] = 0;
		powerSet(i+1, K);
		temp[i] = 1;
		powerSet(i+1, K);
	}


}
