package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_합이0인네정수 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			A[i] = Integer.parseInt(s[0]);
			B[i] = Integer.parseInt(s[1]);
			C[i] = Integer.parseInt(s[2]);
			D[i] = Integer.parseInt(s[3]);
		}
		int[] AB = new int[N*N];
		int[] CD = new int[N*N];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				AB[i*N+j] = A[i]+B[j];
				CD[i*N+j] = C[i]+D[j];
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		long result = 0;
		int l= 0;
		int r= CD.length-1;
		
		while(l<AB.length && r>=0) {
			
			int ab = AB[l];
			int cd = CD[r];
			int abCnt = 0;
			int cdCnt = 0;
			
			int sum = ab+cd;
			
			if(sum==0) {
				
				while( l<AB.length && ab==AB[l] ) {
					l++;
					abCnt++;
				}
				while( r>=0 && cd==CD[r]) {
					r--;
					cdCnt++;
				}
				
				result += (long)abCnt*(long)cdCnt;
			}
			else if(sum > 0) r--;
			else l++;
			
			
		}
		System.out.println(result);
	}

}
