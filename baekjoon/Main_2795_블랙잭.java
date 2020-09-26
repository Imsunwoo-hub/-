package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2795_블랙잭 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int[] ia = new int[N];
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(i!=j && j!=k && i!=k) {
						if(ia[i] + ia[j] + ia[k] <= M) {
							if(result < ia[i] + ia[j] + ia[k]) {
								result = ia[i] + ia[j] + ia[k];
							}
						}
					}
				}
			}
		}
		System.out.println(result);

	}

}
