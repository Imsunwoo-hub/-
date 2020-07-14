package swex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_중간값찾기 {
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d1_2063.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] ia = new int[T];
		for(int tc=0; tc<T; tc++)
		{	
			ia[tc] = sc.nextInt();
		}
		for(int i=0; i<T; i++) {
			for(int j=i; j<T; j++) {
				if(ia[i]>ia[j]) {
					int temp = ia[j];
					ia[j] = ia[i];
					ia[i] = temp;
				}
			}	
		}
		/*for(int i=0; i<T; i++) {
			for(int j=i; j<T; j++) {
				if(ia[i]>ia[j]) {
					ia[i] = ia[i]+ia[j];
					ia[j] = ia[i]-ia[j];
					ia[i] = ia[i]-ia[j];
				}
			}
		}*/
		System.out.println(Arrays.toString(ia));
		int mid = T/2;
		System.out.println(ia[mid]);
		//sc.close();
	}

}
