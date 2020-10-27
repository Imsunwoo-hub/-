package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main_전화번호목록 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
		
			int N = Integer.parseInt(br.readLine());
			int bol = 0;
			
			String[] s = new String[N];
			for(int i=0; i<N; i++) s[i] = br.readLine();
			
			Arrays.sort(s);
			
			for(int i=1; i<N; i++) {
				if(s[i].startsWith(s[i-1])) {
					bol = 1;
					break;
				}
			}
			
			
			if(bol==0) bw.append("YES\n");
			else bw.append("NO\n");
		}
		
		bw.flush();
	}
}
