package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_벌꿀채취 {
	
	static int N,M,C, tempc;
	static int[][] ia, mia;
	static int[] temp, ps;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d9_21151.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] t = br.readLine().split(" ");
			N = Integer.parseInt(t[0]);
			M = Integer.parseInt(t[1]);
			C = Integer.parseInt(t[2]);
			
			ia = new int[N][N];
			mia = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					ia[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					temp = new int[M];
					ps = new int [M];
					int idx = 0;
					tempc = 0;
					for(int k=j; k<j+M; k++) {
						temp[idx++] = ia[i][k];
					}
					powerset(0, M);
					//System.out.println(tempc);
					mia[i][j] = tempc;
				}
			}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int a=0; a<N; a++) {
					for(int b=0; b<N; b++) {
						if(a!=i) {
							if(mia[i][j] + mia[a][b] > result )result = mia[i][j] + mia[a][b];
						}
						else {
							if(j!=b) {
								if(j<b) {
									if(j+(M-1)<b) {
										if(mia[i][j] + mia[a][b] > result )result = mia[i][j] + mia[a][b];
									}
								}
								else {
									if(b+(M-1) < j) {
										if(mia[i][j] + mia[a][b] > result )result = mia[i][j] + mia[a][b];
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("#"+tc+" "+result);
	}
	}

	static void powerset(int n, int c) {
		if(n==c) {
			int count = 0;
			for(int i=0; i<c; i++) {
				if(ps[i]==1){
					count += temp[i];
				}
			}
			if(count <= C) {
				int result = 0;
				for(int i=0; i<c; i++) {
					if(ps[i]==1){
						result += (temp[i]*temp[i]);
					}
				}
				if(result > tempc) tempc = result;
			}
			return;
		}
		ps[n] = 0;
		powerset(n+1, c);
		ps[n] = 1;
		powerset(n+1, c);
	}
}
