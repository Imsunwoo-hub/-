package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_7568_덩치 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] ia = new int[N][2];
		int[] cnt = new int[N];
		
		for(int i=0; i<N; i++) {
			String[] s=  br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(s[0]);
			ia[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int i=0; i<N; i++) {
			int count = 0;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(ia[i][0] < ia[j][0] && ia[i][1] < ia[j][1]) count++;
			}
			cnt[i] = count+1;
		}
		for(int c:cnt) System.out.print(c+" ");
	}

}
