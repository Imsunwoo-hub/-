package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_소수완제품확률 {

	public static void main(String[] args) throws Exception {
		
		
		System.setIn(new FileInputStream("res/input_d6_1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++ ) {
			
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			double d = 0.0;
			if((A==0 && B==0) || (A==100 && B==100)) {
				System.out.printf("#%d %f\n",tc,d);
			}
			else {
				int[] sosu = {2,3,5,7,11,13,17};
				double[] d_a = new double[19]; 
				double[] d_b = new double[19]; 
				double m = Math.pow(2,  18);
				for(int i=0; i<sosu.length; i++) {
					d_a[sosu[i]] = nCr(18, sosu[i]);
					d_b[sosu[i]] = nCr(18, sosu[i]);
				}
				double a = (A/100.0); 
				double b = (B/100.0); 
				double ra = 0.0;
				double rb = 0.0;
				
				for(int i=0; i<sosu.length; i++) {
					d_a[sosu[i]] *= a;
					d_a[sosu[i]] *= 1.0-a;
					ra+=d_a[sosu[i]];
					d_b[sosu[i]] *= b;
					d_b[sosu[i]] *= 1.0-b;
					rb+=d_b[sosu[i]];
				}
			
				
				
				/*
				 * for(int i=0; i<sosu.length; i++) { for(int j=1; j<=sosu[i]; j++) {
				 * d_a[sosu[i]] *= a; } for(int j=0; j<18-sosu[i]; j++ ) { d_a[sosu[i]] *= 1.0 -
				 * a; } ra += d_a[sosu[i]]; for(int j=1; j<=sosu[i]; j++) { d_b[sosu[i]] *= b; }
				 * for(int j=0; j<18-sosu[i]; j++) { d_b[sosu[i]] *= 1.0 - b; } rb +=
				 * d_b[sosu[i]]; }
				 */
				
				System.out.println(ra);
				System.out.println(rb);
			
				d = (ra+rb)-(ra*rb);
				
				System.out.printf("#%d %f\n",tc,d);
				
			}
		
		}
	}
	
	public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1,r-1);
	}
	
	/*
	 * public static double nCr(int n, int r) { if(r==0) return 1.0; if(n<r) return
	 * 0.0; return nCr(n-1,r-1)+nCr(n-1,r); }
	 */

}
