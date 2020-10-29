package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_공유기설치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ia);
		
		int l = 1;
		int r = ia[ia.length-1] - ia[0];
		
		int result = 0;
		
		while(l<=r) {
			int mid = (l+r)/2;
			int cnt = 1;
			int before  = ia[0];
			
			for(int i=0; i<N; i++) {
				int d = ia[i]-before;
				if(d >= mid) {
					cnt++;
					before = ia[i];
				}
			}
			
			if(cnt >= C) {
				result = mid;
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		
		System.out.println(result);

	}

}
