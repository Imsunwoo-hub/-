package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_숫자카드 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		String[] s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(ia);
		
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(s[i]);
			int l=0;
			int r = ia.length-1;
			int bol = 0;
			while(l<=r) {
				int mid = (l+r)/2;
				int y = ia[mid];
				if(x == y) {
					bol = 1;
					break;
				}
				else if(x>y) l  = mid+1;
			
				else r = mid-1;
			}
			if(bol==1) {
				System.out.print(1+" ");
			}
			else System.out.print(0+" ");
		}
		
		
	}

}
