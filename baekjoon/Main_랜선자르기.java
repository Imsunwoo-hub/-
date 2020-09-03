package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_랜선자르기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		
		int[] ia = new int[K];
		for(int i=0; i<K; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		long result = 0;
		long l = 0;
		long r = Integer.MAX_VALUE;
		
		while(l<=r){
			long mid = (l+r)/2;
			
			int sum = 0;
			for(int i=0; i<K; i++) {
				sum += ia[i]/mid;
			}
			
			if(sum<N) r = mid-1;
			else {
				result = mid;
				l = mid+1;
			}
			
		}
		
		System.out.println(result);
	}

}
