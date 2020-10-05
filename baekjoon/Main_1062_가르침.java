package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1062_가르침 {
	
	static int result,N,K;
	static int[] ia;
	static String[] sa;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		sa = new String[N];
		for(int i=0; i<N; i++) {
			sa[i] = br.readLine();
		}
		ia = new int[26];
		result = 0;
		dfs(0,0);
		System.out.println(result);
	}
	
	public static void dfs(int i, int c) {
		if(c==K) {
			int cnt = 0;
			
			for(int a=0; a<N; a++) {
				String word = sa[a];
				int count = 0;
				for(int b=0; b<word.length(); b++) {
					if(ia[word.charAt(b)-97]==0) {
						count++;
						break;
					}
				}
				if(count == 0) cnt++;
			}
			
			if(cnt > result) result = cnt;
			return;
		}
		if(i==26) return;
		ia[i] = 1;
		dfs(i+1, c+1);
		ia[i] = 0;
		dfs(i+1, c);
	}
}
