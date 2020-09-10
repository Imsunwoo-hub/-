package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_근손실 {
	
	static int[] ia, v;
	static int N, K, result;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		
		ia = new int[N];
		v = new int[N];
		
		s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		
		result = 0;
		
		dfs(0,500);
		
		System.out.println(result);

	}
	
	public static void dfs(int n, int k) {
		if(k<500) return;
		if(n==N) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]==0) {
				v[i] = 1;
				dfs(n+1, k-K+ia[i]);
				v[i]=0;
			}
		}
	}

}
