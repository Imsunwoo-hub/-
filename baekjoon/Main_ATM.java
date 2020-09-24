package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_ATM {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		String[] s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(ia);
		int result = ia[0] ;
		for(int i=1; i<N; i++) {
			ia[i] = ia[i-1]+ia[i];
			result += ia[i];
		}
		
		System.out.println(result);
	}

}
