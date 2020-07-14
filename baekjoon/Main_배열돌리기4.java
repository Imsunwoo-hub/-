package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_배열돌리기4 {
	
	public static int min,K, ia[][], ka[][], d[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		ia = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
			}
		}
		ka = new int[K][3];
		d = new int[K];
		for(int i=0; i<K; i++) {
			d[i] = i;
			String[] t = br.readLine().split(" ");
			ka[i][0] = Integer.parseInt(t[0]);
			ka[i][1] = Integer.parseInt(t[1]);
			ka[i][2] = Integer.parseInt(t[2]);
 		}
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(min);
	}
	
	public static void perm(int c) {
		if(c==K) {
			for(int i=0; i<K; i++) {
				int start_i = ka[d[i]][0]-ka[d[i]][2]-1;
				int start_j = ka[d[i]][1]-ka[d[i]][2]-1;
				int end_i = ka[d[i]][0]+ka[d[i]][2]-1;
				int end_j = ka[d[i]][1]+ka[d[i]][2]-1;
				
			}
			for(int i=0; i<ia.length; i++) {
				int temp = 0;
				int bol = 0;
				for(int j=0; j<ia[i].length; j++) {
					temp += ia[i][j];
					if(temp<=min) {
						bol = 1;
						break;
					}
				}
				if(bol==0) min = temp;
			}
		}
		
		for(int i=c; i<K; i++) {
			swap(i,c);
			perm(c+1);
			swap(i,c);
		}
	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int temp =d[i];
		d[i] = d[j];
		d[j] = temp;
	}

}
