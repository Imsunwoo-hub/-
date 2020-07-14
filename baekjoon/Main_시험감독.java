package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_시험감독 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int[] ia = new int[N];
		String[] t = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(t[i]);
		}
		String[] ts = br.readLine().split(" ");
		int B = Integer.parseInt(ts[0]);
		int C = Integer.parseInt(ts[1]);
		
		long result = 0;
		for(int i=0; i<N; i++) {
			int temp = ia[i];
			result++;
			temp -= B;
			if(temp<0) continue;
			int x = temp/C;
			int y = temp%C;
			if(y==0) result += x;
			else result += x+1;
		}
		
		System.out.println(result);
	}

}
