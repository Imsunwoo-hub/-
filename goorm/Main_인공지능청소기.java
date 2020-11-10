package goorm;

import java.io.*;
public class Main_인공지능청소기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for(int tc=1; tc<=T; tc++){
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			if(Math.abs(x)+Math.abs(y) <= d) {
				if(	Math.abs(Math.abs(x)+Math.abs(y)-d)%2==0) System.out.println("YES");
				else System.out.println("NO");
			}
			else System.out.println("NO");
			
		}
	
	}
}
