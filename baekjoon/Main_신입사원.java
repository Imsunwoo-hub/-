package baekjoon;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;

public class Main_신입사원 {
	
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] ia = new int[N+1][2];
			
			
			for(int i=1; i<=N; i++) {
				String[] s = br.readLine().split(" ");
				ia[i][0] = Integer.parseInt(s[0]);
				ia[i][1] = Integer.parseInt(s[1]);
				
			}
			Arrays.sort(ia, new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					
					return Integer.compare(o1[0], o2[0]);
				}});
			int result = N; 
			
			int temp = ia[1][1];
			for(int i=2; i<=N; i++) {
				if(ia[i][1] > temp) {
					result--;
				}
				temp = Math.min(temp, ia[i][1]);
			}
			System.out.println(result);		
		}
		
	}

}
