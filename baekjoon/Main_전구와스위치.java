package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_전구와스위치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a1 = new int[N];
		int[] a2 = new int[N];
		int[] b = new int[N];
		
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			a1[i] = s.charAt(i)-'0';
			a2[i] = s.charAt(i)-'0';
		}
		s = br.readLine();
		for(int i=0; i<N; i++) {
			b[i] = s.charAt(i)-'0';
		}
		
		int result = -1;
		
		a1[0] = (a1[0]+1)%2;
		a1[1] = (a1[1]+1)%2;
		int cnt1 = solve(a1,b,1);
		
		if(check(a1,b)) {
			if(result==-1) result = cnt1;
			else result = Math.min(result, cnt1);
		}
		int cnt2 = solve(a2, b, 0);
		
		if(check(a2,b)) {
			if(result==-1) result = cnt2;
			else result = Math.min(result, cnt2);
		}
		
		System.out.println(result);
	}
	
	public static int solve(int[] a, int[] b, int result) {
		
		for(int i=1; i<a.length; i++) {
			if(a[i-1] != b[i-1]) {
				result++;
				for(int k=i-1; k<=i+1; k++) {
					if(k>=0 && k<a.length) a[k] = (a[k]+1)%2;
				}
			}
		}
		return result;
	}
	
	public static boolean check(int[] a, int[] b) {
		for(int i=0; i<a.length; i++) {
			if(a[i]!=b[i]) {
				return false;
			}
		}
		return true;
	}

}
