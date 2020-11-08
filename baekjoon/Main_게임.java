package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_게임 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		long X = Integer.parseInt(s[0]);
		long Y = Integer.parseInt(s[1]);
		long Z = (100*Y)/X;
		
		long result = -1;
		long l = 0;
		long r = 1000000000;
		while(l<=r) {
			long mid = (l+r)/2;
			long TZ = (100*(Y+mid)) / (X+mid);
			if(TZ <= Z) {
				result = mid+1;
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		
		System.out.println(result);
	}

}
