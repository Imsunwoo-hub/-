package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_로프 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] =  Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ia);
		long max = 0;
		
		for(int i=N-1; i>=0; i--) {
			ia[i] = ia[i]*(N-i);
			if(max < ia[i]) max = ia[i];
		}
		
		System.out.println(max);
	}

}
