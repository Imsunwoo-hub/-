package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_펜션 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char[][] ca = new char[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String t = br.readLine();
			for(int j=1; j<=M; j++) {
				ca[i][j] = t.charAt(j-1);
			}
		}
		
		s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		
		int result = -1;
		
		while(start < end) {
			//System.out.println(start);
			int idx = -1;
			int max = 0;
			for(int j=1; j<=M; j++) {
				if(ca[start][j]=='O') {
					int cnt = 0;
					for(int i=start; i<=N; i++) {
						if(ca[i][j]=='X') break;
						cnt++;
					}
					if(cnt > max) {
						max = cnt;
						idx = j;
					}
				}
			}
			if(idx == -1) {
				result = -1;
				break;
			}
			else {
				start+=max;
				result++;
			}
		}
		
		System.out.println(result);

	}

}
