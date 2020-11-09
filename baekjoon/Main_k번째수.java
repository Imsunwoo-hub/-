package beakjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class Main_k번째수 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int l = 1;
		int r = K;
		int result = 0;
		while(l<=r) {
			int mid = (l+r)/2;
			int count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
			if(K > count) {
				l = mid+1;
			}
			else {
				result = mid;
				r = mid-1;
			}
			
		}
		
		System.out.println(result);

	}

}
