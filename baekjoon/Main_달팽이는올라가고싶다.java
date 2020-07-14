package baekjoon;

import java.util.Scanner;

public class Main_달팽이는올라가고싶다{

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int l = 1;
		int r = V;
		int result = 0;
		while(l <= r) {
			int mid = (l+r)/2;
			//System.out.println(mid);
			if(((A-B)*(mid-1))+A >= V) {
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
