package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1026_보물 {


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(s1[i]);
			B[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int result = 0;
		for(int i=0; i<N; i++) {
			result += A[i]*B[N-1-i];
		}
		System.out.println(result);
	}
}
