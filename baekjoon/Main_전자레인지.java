package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_전자레인지 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] times = {300,60,10};
		int[] counts = new int[3];
		
		while(true) {
			
			int bol = 0;
			for(int i=0; i<3; i++) {
				if(times[i] < N) {
					counts[i] += N/times[i];
					N %= times[i];
					bol = 1;
					break;
				}
			}
			
			if(N==0) {
				for(int c:counts)System.out.print(c+" ");
				return;
			}
			if(bol==0) {
				System.out.println(-1);
				return;
			}
		}

	}

}
