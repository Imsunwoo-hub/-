package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_연산자끼워넣기 {
	
	public static int max, min, ia[], op[], N;

	public static void main(String[] args) throws Exception {
		
		// +0 -1 *2 /3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ia = new int[N];
		int[] operator = new int[4];
		String[] t = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(t[i]);
		}
		String[] o = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(o[i]);
		}
		op = new int[N-1];
		int idx=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<operator[i]; j++) {
				op[idx++] = i;
			}
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		perm(0);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void perm(int c) {
		if(c==N-1) {
			int maxt = ia[0];
			int mint = ia[0];
			for(int i=0; i<N-1; i++) {
				if(op[i]==0) {
					maxt = maxt+ia[i+1];
					mint = mint+ia[i+1];
				}
				else if(op[i]==1) {
					maxt = maxt-ia[i+1];
					mint = mint-ia[i+1];
				}
				else if(op[i]==2) {
					maxt = maxt*ia[i+1];
					mint = mint*ia[i+1];
				}
				else if(op[i]==3) {
					maxt = maxt/ia[i+1];
					mint = mint/ia[i+1];
				}
			}
			if(maxt>max) max = maxt;
			if(mint<min) min = mint;
			
			return;
		}
		
		for(int i=c; i<N-1; i++) {
			swap(i,c);
			perm(c+1);
			swap(i,c);
		}
	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int t = op[i];
		op[i] = op[j];
		op[j] = t;
	}

}
