package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_최소대금 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] p = new int[3];
		int[] j = new int[2];
		
		for(int i=0; i<5; i++) {
			if(i<3) p[i] = Integer.parseInt(br.readLine());
			else j[i-3] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(p);
		Arrays.sort(j);
		
		double temp = p[0]+j[0];
		
		String result = String.format("%.1f", temp*1.1);
		
		System.out.println(result);
		
	}

}
