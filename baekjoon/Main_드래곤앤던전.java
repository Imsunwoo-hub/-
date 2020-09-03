package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_드래곤앤던전 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int H = Integer.parseInt(s[1]);
		long max = 0;
		long[][] ia = new long[N][3];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			long t = Integer.parseInt(s[0]);
			long a = Integer.parseInt(s[1]);
			long h = Integer.parseInt(s[2]);
			ia[i][0] = t;
			ia[i][1] = a;
			ia[i][2] = h;
			if(t==1) {
				if(h%H==0) max +=a *(h/H) ;
				else max += a*(h/H)+a;
			}
		}
		
		long result = 0;
		long l = 0;
		long r = max;
		
		while(l<=r) {
			long mid = (l+r)/2;
			
			long hp = mid;
			long att = H;
			int bol = 0;
			for(int i=0; i<N; i++) {
				if(ia[i][0]==1) {
					long hit = 0;
					if(ia[i][2]%att==0) hit = ia[i][2]/att;
					else hit = ia[i][2]/att+1;
					
					if(hp > ia[i][1]*(hit-1)) {
						hp -= ia[i][1]*(hit-1);
					}
					else {
						bol = 1;
						break;
					}
				}
				else {
					att += ia[i][1];
					hp += ia[i][2];
					if(hp>mid) hp = mid;
				}
			}
			
			if(bol==0) {
				result = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
		}
		
		System.out.println(result);
		
	}

}
