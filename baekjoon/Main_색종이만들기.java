package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_색종이만들기 {
	
	static int[] cnt, ia[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ia = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		cnt = new int[2];
		
		divide(0, 0, N);
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);

	}
	
	public static void divide(int i, int j, int n) {
		int bol = 0;
		for(int a=i; a<i+n; a++) {
			for(int b=j; b<j+n; b++) {
				if(ia[i][j]!=ia[a][b]) {
					bol = 1;
					break;
				}
			}
		}
		if(bol==0) {
			cnt[ia[i][j]]++;
			return;
		}
		divide(i,j,n/2);
		divide(i+n/2,j,n/2);
		divide(i,j+n/2,n/2);
		divide(i+n/2,j+n/2,n/2);
	}

}
