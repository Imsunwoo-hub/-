package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_쿼드트리 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<N; j++) {
				ia[i][j] = t.charAt(j)-'0';
			}
		}
		
		solve(0,0,N,ia);

	}
	
	
	public static void solve(int a, int b, int n, int[][] ia) {
		int bol = 0;
		int x = ia[a][b];
		
		for(int i=a; i<a+n; i++) {
			for(int j=b; j<b+n; j++) {
				if(ia[i][j]!=x) {
					bol = 1;
					break;
				}
			}
			if(bol==1) break;
		}
		
		if(bol==0) {
			System.out.print(x);
		}
		else {
			System.out.print("(");
			n/=2;
			solve(a, b,n ,ia);
			solve(a, b+n,n ,ia);
			solve(a+n, b,n ,ia);
			
			solve(a+n, b+n,n ,ia);
			System.out.print(")");
		}
	}

}
