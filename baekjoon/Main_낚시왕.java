package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_낚시왕 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int R = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		int M = Integer.parseInt(s[2]);
		int[][] map = new int[R][C];
		int[] ia = null;
		ArrayList<int[]> slist = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String[] t = br.readLine().split(" ");
			ia = new int[5];
			for(int j =0; j<5; j++) {
				if(j<2) {
					ia[j] = Integer.parseInt(t[j])-1;
				}
				else ia[j] = Integer.parseInt(t[j]);
			}
			map[ia[0]][ia[1]] += 1;
			slist.add(ia);
		}
		 
		int man = -1;
		int result = 0;
		int max = 0; 
		int idx = 0;
		
		/*System.out.println(slist.size());
		for(int[] m : map ) System.out.println(Arrays.toString(m));
		System.out.println();*/
		
		ArrayList<Integer> temp = new  ArrayList<>();
		while(man<C-1) {
			// 사람이동
			man++;
			// 상어잡음
			max = R;
			idx = -1;
			for(int i=0; i<slist.size(); i++) {
				if(slist.get(i)[1] == man) {
					if(slist.get(i)[0] < max) {
						max = slist.get(i)[0];
						idx = i;
					}
				}
			}
			if(idx != -1) {
				map[slist.get(idx)[0]][slist.get(idx)[1]] -= 1;
				result += slist.get(idx)[4];
				slist.remove(idx);
			}
			
			if(slist.size()==0) break;
			// 상어이동
			// d  1위  2아래  3오른  4왼
			for(int i=0; i<slist.size(); i++) {
				int[] a = slist.get(i);
				
				if(a[3]==1) {
					int c = a[2];
					int d = -1;
					map[a[0]][a[1]] -= 1;
					for(int x=0; x<c; x++) {
						if(a[0] + d < 0 || a[0] + d >  R-1) {
							d = d *-1;
							if(a[3] == 1) a[3] = 2;
							else if(a[3] ==2) a[3] = 1;
						}
						a[0] += d;
						
					}
					
				}
				else if(a[3]==2) {
					int c = a[2];
					int d = 1;
					map[a[0]][a[1]] -= 1;
					for(int x=0; x<c; x++) {
						if(a[0] + d < 0 || a[0] +d > R-1) {
							d = d * -1;
							if(a[3] == 1) a[3] = 2;
							else if(a[3] ==2) a[3] = 1;
						}
						a[0] += d;
					}
				}
				else if(a[3]==3) {
					int c = a[2];
					int d = 1;
					map[a[0]][a[1]] -= 1;
					for(int x=0; x<c; x++) {
						if(a[1] + d  < 0 || a[1] + d >  C-1) {
							d = d * -1;
							if(a[3] == 3) a[3] = 4;
							else if(a[3] ==4) a[3] = 3;
						}
						a[1] += d;
					}
				}
				else if(a[3]==4) {
					int c = a[2];
					int d = -1;
					map[a[0]][a[1]] -= 1;
					for(int x=0; x<c; x++) {
						if(a[1] + d <  0 || a[1] +d > C-1) {
							d = d * -1;
							if(a[3] == 3) a[3] = 4;
							else if(a[3] == 4) a[3] = 3;
						}
						a[1] += d;
					}
					
					
				}
				map[a[0]][a[1]]++;
				slist.set(i, a);
			}
			
			/*for(int[] m : map ) System.out.println(Arrays.toString(m));
			System.out.println();
			for(int[] s1:slist) System.out.println(Arrays.toString(s1));*/
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] > 1) {
						map[i][j] = 1;
						temp.clear();
						int mx = 0;
						int ix = -1;
						for(int k=0; k<slist.size(); k++) {
							if(slist.get(k)==null) continue;
							if(i == slist.get(k)[0] && j == slist.get(k)[1]) {
								if(slist.get(k)[4] > mx) {
									mx = slist.get(k)[4];
									ix = k;
								}
								temp.add(k);
							}
						}
						if(temp.size()==0) break;
						for(int k=0; k<temp.size(); k++) {
							if(temp.get(k) != ix) slist.set(temp.get(k), null);
						}
					}
				}
			}
			
			for(int i =0 ; i<slist.size(); i++) {
				if(slist.get(i)==null) {
					slist.remove(i);
					if(slist.size()==0) break;
					i--;
				}
			}
			
			/*for(int[] m : map ) System.out.println(Arrays.toString(m));
			System.out.println();*/
			
			
		}
		System.out.println(result);
	}

}
