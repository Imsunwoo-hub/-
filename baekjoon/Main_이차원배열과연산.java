package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_이차원배열과연산{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int r = Integer.parseInt(s[0])-1;
		int c = Integer.parseInt(s[1])-1;
		int k = Integer.parseInt(s[2]);
		
		int[][] ia = new int[100][100];
		
		for(int i=0; i<3; i++) {
			String[] t = br.readLine().split(" ");
			for(int j =0; j<3; j++) {
				ia[i][j] = Integer.parseInt(t[j]);
			}
		}
		
		int rs = 3;
		int cs = 3;
		
		int result = 0;
		// --- 행         | 열
		while(result<=100) {
			
			if(ia[r][c]==k) break;
			
			result++;
		
			// R연산
			if(rs>=cs)  {
				cs = 0;
				for(int i=0; i<100; i++ ) {
					ArrayList<int[]> list = new ArrayList<>();
					int[] ca = new int[101];
					for(int j=0; j<100; j++) {
						ca[ia[i][j]]++;
					}
					for(int j=1; j<=100; j++) {
						if(ca[j] != 0) list.add(new int[] {j, ca[j]});
					}
					Collections.sort(list, new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							return Integer.compare(o1[1], o2[1]);
						}
					});
					int idx = 0;
					for(int[] l : list) {
						if(idx>99) break;
						ia[i][idx++] = l[0];
						ia[i][idx++] = l[1];
					}
					
					if(idx > cs ) cs = idx;
					for(int j=idx; j<100; j++) {
						ia[i][j] = 0;
					}
				}
			}
				
			//C연산
			else {
				rs = 0;
				for(int i=0; i<100; i++ ) {
					ArrayList<int[]> list = new ArrayList<>();
					int[] ca = new int[101];
					for(int j=0; j<100; j++) {
						ca[ia[j][i]]++;
					}
					for(int j=1; j<=100; j++) {
						if(ca[j] != 0) list.add(new int[] {j, ca[j]});
					}
					Collections.sort(list, new Comparator<int[]>() {

						@Override
						public int compare(int[] o1, int[] o2) {
							return Integer.compare(o1[1], o2[1]);
						}
					});
					int idx = 0;
					for(int[] l : list) {
						if(idx>99) break;
						ia[idx++][i] = l[0];
						ia[idx++][i] = l[1];
					}
					if(idx > rs ) rs = idx;
					for(int j =idx; j<100; j++) {
						ia[j][i] = 0;
					}
					
				}
			}
				
				//for(int[] a:ia) System.out.println(Arrays.toString(a));
				
		}
		if(result > 100 ) result  = -1;
		System.out.println(result);

	}

}