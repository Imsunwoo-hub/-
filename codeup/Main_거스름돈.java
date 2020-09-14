package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_거스름돈 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] money = {50000,10000,5000,1000,500,100,50,10};
		int result = 0;
		for(int i=0; i<money.length; i++) {
			result += N/money[i];
			N = N%money[i];
		}
		System.out.println(result);
	}

}
