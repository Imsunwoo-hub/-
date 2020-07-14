package swex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_최빈수구하기 {
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d2_1204.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int[] ia = new int[1000];
			int[] ca = new int[101];
			for(int i = 0; i<1000; i++) {
				ia[i] = sc.nextInt();
				ca[ia[i]]++;
			}
			/*for(int i=0; i<ia.length; i++) {
				ca[ia[i]]++;
			}*/
			int max = ca[0];
			int result = 0;
			for(int i=0; i<ca.length; i++) {
				if(max <= ca[i]) {
					max = ca[i];
					result = i;
				}
			}

			//System.out.println(Arrays.toString(ia));
			System.out.println("#"+ N + " "+ result);
			//System.out.print("#");
		}
	}

}
