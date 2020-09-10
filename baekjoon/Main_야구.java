package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_야구 {
	
	static int result, N;
	static int[][] ia;
	static int[] data;


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ia = new int[N][9];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		data = new int[8];
		for(int i=2; i<=9; i++) {
			data[i-2] = i;
		}
		
		result = 0;
		
		perm(0);
		
		System.out.println(result);
		
	}
	
	public static void perm(int n) {
		if(n==8) {
			int[] seq = new int[9];
			for(int i=0; i<9; i++) {
				if(i==3) seq[i] = 1;
				else if(i<3) seq[i] = data[i];
				else seq[i] = data[i-1];
			}
			
			int sum = 0;
			int inning = 0;
			int idx = 0;
		
			while(inning < N) {
				
				int out = 0;
				int[] ru = new int[3];
				
				while(out < 3) {
					int j = seq[idx]-1;
					idx = (idx+1)%9;
					
					if(ia[inning][j]==0) {
						out++;
					}
					else if(ia[inning][j]==1) {
						for(int i=2; i>=1; i--) {
							if(i==2 && ru[i]!=0) {
								ru[i]=0;
								sum++;
							}
							ru[i] = ru[i-1];
						}
						ru[0] = j+1;
					}
					else if(ia[inning][j]==2) {
						for(int i=2; i>0; i--) {
							if(ru[i]!=0) {
								sum++;
								ru[i] = 0;
							}
						}
						if(ru[0] != 0) {
							ru[2] = ru[0];
							ru[0] = 0;
						}
						ru[1] = j+1;
					}
					else if(ia[inning][j]==3) {
						for(int i=0; i<3; i++) {
							if(ru[i]!=0) sum++;
							ru[i] = 0;
						}
						ru[2] = j+1;
					}
					else if(ia[inning][j]==4) {
						for(int i=0; i<3; i++) {
							if(ru[i]!=0) sum++;
							ru[i] = 0;
						}
						sum++;
					}
				}
				
				inning++;
			}
			if(sum > result) result = sum;
			return;
		}
		
		for(int i=n; i<8; i++) {
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
