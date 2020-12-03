package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_꿍의우주여행 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				s = br.readLine().split(" ");
				double v = Double.parseDouble(s[0]);
				double f = Double.parseDouble(s[1]);
				double c = Double.parseDouble(s[2]);
				
				if(K/v*c <= f) cnt++;	
			}
			
			bw.append(cnt+"\n");
		}
		
		bw.flush();
	}

}
