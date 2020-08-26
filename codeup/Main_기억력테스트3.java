package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_기억력테스트3 {
	
	static int answer;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		int M = Integer.parseInt(br.readLine());
		String[] t = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			int qua = Integer.parseInt(t[i]);
			answer = -1;
			search(0, N, qua, ia);
			System.out.print(answer+" ");
		}
		
		
	}
	
	public static void search(int start, int end, int target, int[] ia) {
		if(end<start) return;
		int mid = (start+end)/2;
		if(ia[mid] == target) {
			answer = mid+1;
			return;
		}
		if(ia[mid]<target) {
			search(mid+1, end, target, ia);
		}
		if(ia[mid]>target) {
			search(start, mid-1, target, ia);
		}
		
	}

}
