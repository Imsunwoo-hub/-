package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[] A = new int[N];
			s = br.readLine().split(" ");
			for(int i=0; i<A.length; i++) A[i] = Integer.parseInt(s[i]);
			
			s = br.readLine().split(" ");
			int[] B = new int[M];
			for(int i=0; i<B.length; i++) B[i] = Integer.parseInt(s[i]);
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int result = 0;
			int idx = 0;
		
			
			for(int i=0; i<N; i++) {
				int count = 0;
				for(int j=idx; j<M; j++) {
					if(A[i] > B[j]) {
						count++;
						idx = j+1;
					}
				}
				result += count * (N-i);
				
			}
	
			System.out.println(result);
		}
		
		
	}

}
