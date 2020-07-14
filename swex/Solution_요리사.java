package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_요리사 {
	
	public static int N, ia[][], temp[], min;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			ia = new int[N][N];
			temp = new int[N/2];
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					ia[i][j] = Integer.parseInt(s[j]);
				}
			}
			min = Integer.MAX_VALUE;
			comb(N,N/2);
			System.out.println("#"+tc+" "+min);
			
		}

	}
	public static void comb(int n, int r) {
		if(n<r) return;
		if(r==0) {
			int[] temp2 = new int[N/2];
			int idx = 0;
			for(int i=0; i<N; i++) {
				int bol = 0;
				for(int j=0; j<N/2; j++) {
					if(i==temp[j])
						{
						bol = 1;
						break;
						}
				}
				if(bol==0) temp2[idx++] = i;
			}
			int f1 = 0;
			int f2 = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					f1 += ia[temp[i]][temp[j]];
					f2 += ia[temp2[i]][temp2[j]];
					
				}
			}
			int result = Math.abs(f1-f2);
		
			if(result<min) min = result;
			return;
		}
		temp[r-1] = n-1; 
		comb(n-1,r-1);
		comb(n-1,r);
	}

}
