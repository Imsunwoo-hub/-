package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9372_상근이의여행 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++ ) {
			
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int[] p = new int[N+1];
			for(int i=1; i<=N; i++) p[i] = i;
			
			for(int i=0; i<M; i++) {
				s = br.readLine().split(" ");
			}
			int result = N-1;
		
			
			bw.append(result+"\n");
		}
		
		bw.flush();
	}
}
