package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_최소대금 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] p = new int[3];
		int[] j = new int[2];
		
		for(int i=0; i<3; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<2; i++) {
			j[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(p);
		Arrays.sort(j);
		
		double temp  = (p[0]+j[0]) + ((p[0]+j[0])*0.1);
		String result = temp+"";
		int bol = 0;
		for(int i=0; i<result.length(); i++) {
			if(result.charAt(i)=='.') {
				System.out.print(result.charAt(i));
				bol = 1;
				continue;
			}
			if(bol==0) {
				System.out.print(result.charAt(i));
			}
			else {
				System.out.print(result.charAt(i));
				break;
			}
		}
		System.out.println();
	}

}
