package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_회의실배정 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int[][] ia = new int[N][2];
		
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(t[0]);
			ia[i][1] = Integer.parseInt(t[1]);
		} 
		
		Arrays.sort(ia, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[0], o2[0]);
				if(r==0) r = Integer.compare(o1[1]-o1[0], o2[1]-o2[0]);
				if(r==0) r = Integer.compare(o1[1], o2[1]);
				return r;
			}
		});
		
		//for(int[] a:ia) System.out.print(Arrays.toString(a));
		int start = ia[0][0];
		int end = ia[0][1];
		int result = 1;
		for(int i=1; i<N; i++ ) {
			if(end > ia[i][0]) {
				if(ia[i][1]<end) {
					start = ia[i][0];
					end = ia[i][1];
				}
			}
			else {
				result++;
				start = ia[i][0];
				end = ia[i][1];
			}
		}
			
		System.out.println(result);
		
	}

}

