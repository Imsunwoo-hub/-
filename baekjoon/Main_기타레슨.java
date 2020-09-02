package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_기타레슨 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] ia = new int[N];
		
		s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		
		int result = 0;
		int l = 0;
		int r = 1000000000;
		
		while(l<=r) {
			int mid = (l+r)/2;
			int cnt = 0;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(sum+ia[i]<=mid) {
					sum+= ia[i];
				}
				else {
					sum = ia[i];
					if(sum > mid) {
						cnt+=M;
						break;
					}
					cnt++;
				}
			
			}
			
			if(sum <= mid) cnt++; 
			else cnt+=2;
			
	
			if(cnt<=M) {
				result = mid;
				r = mid-1;
			}
			
			else {
				l = mid+1;
			}
		}
		
		System.out.println(result);

	}

}
