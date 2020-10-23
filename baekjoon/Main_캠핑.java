package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_캠핑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 0;
		
		while(true) {
			tc++;
			String[] s = br.readLine().split(" ");
			int L  = Integer.parseInt(s[0]);
			int P  = Integer.parseInt(s[1]);
			int V  = Integer.parseInt(s[2]);
			if(L==0 && P==0 && V==0) break;
			
			int result = 0;
			
			while(true) {
				if(V < L) {
					if(V > 0)result += V;
					break;
				}
				V -= P;
				result += L; 
			}
			
			System.out.println("Case "+tc+": "+result);
			
		}

	}

}
