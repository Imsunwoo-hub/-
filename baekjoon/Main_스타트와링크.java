package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_스타트와링크 {
	
	public static int N, ia[][], temp[],r[], min;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ia = new int[N][N];
		r = new int[N];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
				r[i] = i;
			}
		}
		min = Integer.MAX_VALUE;
		temp = new int[N/2];
		comb(N, N/2);
		System.out.println(min);
		
	}
	
	public static void comb(int n, int c) {
		if(n<c)return;
		if(c==0) {
			int start = 0;
			int link = 0;
			int[] temp2 = new int[N/2];
			int idx=0;
			for(int i=0; i<N; i++) {
				int bol=0;
				for(int j=0; j<N/2; j++) {
					if(i==temp[j]) {
						bol=1;
						break;
					}
				}
				if(bol==0) temp2[idx++] = i;
			}
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					if(i!=j) {
						start += ia[temp[i]][temp[j]];
						link += ia[temp2[i]][temp2[j]];
					}
				}
			}
			int res = Math.abs(start-link);
			if(res<min) min = res;
			return;
		}
		temp[c-1] = r[n-1];
		comb(n-1,c-1);
		comb(n-1,c);
	}
}

