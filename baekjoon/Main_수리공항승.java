package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_수리공항승 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) ia[i] = Integer.parseInt(s[i]);
		
		Arrays.sort(ia);
		
		int count = 0;
		int temp = 0;
		
		for(int i=0; i<N; i++) {
			if(temp==0) {
				count++;
				temp = ia[i]+(K-1);
			}
			else if(ia[i] > temp) {
				count++;
				temp = ia[i]+(K-1);
			}
		}
		System.out.println(count);
	}

}
