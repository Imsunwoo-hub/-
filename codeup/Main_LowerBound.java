package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_LowerBound {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) ia[i] = Integer.parseInt(s[i]);
		
		int l = 0;
		int r = N-1;
		
		int result = -1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			
			if(ia[mid] >= K) {
				result = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
			
		}
		
		if(result == -1) System.out.println(N+1);
		else System.out.println(result+1);

	}

}
