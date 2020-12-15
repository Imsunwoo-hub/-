package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_내려가기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ia[][] = new int[N][3];
		int[][] minDp = new int[N][3];
		int[][] maxDp = new int[N][3];
		
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
				if(i==0) {
					minDp[i][j] = ia[i][j];
					maxDp[i][j] = ia[i][j];
				}
				else if(i==N-1) {
					if(j+1 < 3 && j-1 >= 0) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], Math.min(ia[i][j]+minDp[i-1][j-1], ia[i][j]+minDp[i-1][j+1]));
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], Math.max(ia[i][j]+maxDp[i-1][j-1], ia[i][j]+maxDp[i-1][j+1]));
					}
					else if(j+1 < 3) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], ia[i][j]+minDp[i-1][j+1]);
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], ia[i][j]+maxDp[i-1][j+1]);
					}
					else if(j-1 >= 0) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], ia[i][j]+minDp[i-1][j-1]);
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], ia[i][j]+maxDp[i-1][j-1]);
					}
					if(minDp[i][j] < min) min = minDp[i][j];
					if(maxDp[i][j] > max) max = maxDp[i][j];
				}
				else {
					if(j+1 < 3 && j-1 >= 0) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], Math.min(ia[i][j]+minDp[i-1][j-1], ia[i][j]+minDp[i-1][j+1]));
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], Math.max(ia[i][j]+maxDp[i-1][j-1], ia[i][j]+maxDp[i-1][j+1]));
					}
					else if(j+1 < 3) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], ia[i][j]+minDp[i-1][j+1]);
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], ia[i][j]+maxDp[i-1][j+1]);
					}
					else if(j-1 >= 0) {
						minDp[i][j] = Math.min(ia[i][j]+minDp[i-1][j], ia[i][j]+minDp[i-1][j-1]);
						maxDp[i][j] = Math.max(ia[i][j]+maxDp[i-1][j], ia[i][j]+maxDp[i-1][j-1]);
					}
				}
			}
		}
		
		System.out.println(max+" "+min);

	}

}
