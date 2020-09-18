package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_숫자야구 {
	
	static int N, result;
	static int[] data;
	static String[][] ia;
	static int[] num = {1,2,3,4,5,6,7,8,9};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		data = new int[3];
		ia = new String[N][3];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			ia[i] = s;
		}
		result = 0;
		
		comb(9,3);
		
		System.out.println(result);
	}
	
	public static void comb(int n, int c) {
		if(n<c) return;
		if(c==0) {
			perm(0);
			return;
		}
		data[c-1] = num[n-1];
		comb(n-1,c-1);
		comb(n-1,c);
		
	}
	
	public static void perm(int n) {
		if(n==3) {
			int cnt = 0;
			for(int i=0; i<N; i++) {
				String[] t = ia[i];
				int s = 0;
				int b = 0;
				for(int j=0; j<3; j++) {
					if(t[0].charAt(j)-'0' == data[j]) {
						s++;
					}
					else {
						for(int k=0; k<3; k++) {
							if(k==j) continue;
							if(t[0].charAt(k)-'0'== data[j]) b++;
						}
					}
				}
				if(s==t[1].charAt(0)-'0' && b==t[2].charAt(0)-'0') cnt++;
				else break;
			}
			
			if(cnt == N) result++;
			return;
		}
		
		for(int i=n; i<3; i++) {
			swap(i,n);
			perm(n+1);
			swap(i,n);
		}
	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
