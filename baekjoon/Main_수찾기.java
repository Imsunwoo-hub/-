package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_수찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(ia);
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(s[i]);
			int l = 0; 
			int r = ia.length-1;
			int bol = 0;
			while(l<=r) {
				int mid = (l+r)/2;
				if(ia[mid]==x) {
					bol = 1;
					break;
				}
				else if(ia[mid] < x) l = mid+1;
				else r = mid-1;
			}
			if(bol==1) System.out.println(1);
			else System.out.println(0);
		}

	}

}
