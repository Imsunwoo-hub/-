package swex;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_최장증가부분수열 {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		ArrayList list = new ArrayList();
		
		for(int tc = 1; tc <= T; tc++)
		{
			list.clear();
			int N;
			N =sc.nextInt();
			int[] ia = new int[N];
			for(int i=0; i<N; i++) {
				ia[i] = Integer.parseInt(sc.next());
			}
			for(int i=0; i<N; i++) {
				if(i==0) {
					list.add(ia[i]);
				}
				else {
					int a = (int) list.get(list.size()-1);
					if(i==1) {
						if( a >= ia[i] ) {
							list.remove(list.size()-1);
							list.add(ia[i]);
						}
						else {
							list.add(ia[i]);
						}
					}
					else {
						if( a > ia[i] ) {
							int bol = 0;
							for(int j=0; j<list.size()-1; j++) {
								if((int)list.get(j)>ia[i]) {
									bol=1;
									break;
								}
							}
							if(bol==0) {
								list.remove(list.size()-1);
								list.add(ia[i]);
						}
						else {
							continue;
						}
					}
					else {
						list.add(ia[i]);
					}
					}
				}
			}
			//System.out.println(list);
			int size = list.size();
	
			System.out.println("#"+ tc + " "+ size);
	}
	}
	}
