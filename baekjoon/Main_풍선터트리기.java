package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_풍선터트리기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] ia = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
			
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		int idx = 0;
		while(true) {
			int a = ia[idx];
			sb.append((idx+1)+" ");
			//System.out.print(idx+1+" ");
			ia[idx] = 0;
			cnt++;
			if(cnt==N) break;
			if(a>0) {
				int i = 0;
				while(i<a) {
					idx +=1;
					if(idx>=N) idx = 0;
					if(ia[idx]!=0) i++;
				}
			}
			else {
				a *= -1;
				int i=0;
				while(i<a) {
					idx -= 1;
					if(idx<0) idx = N-1;
					if(ia[idx]!=0) i++;
				}
			}
		}
		
		System.out.println(sb);
	}	
}

