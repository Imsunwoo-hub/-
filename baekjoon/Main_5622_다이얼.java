package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5622_다이얼 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int result = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c>='A' && c<='C') result += 3;
			if(c>='D' && c<='F') result += 4;
			if(c>='G' && c<='I') result += 5;
			if(c>='J' && c<='L') result += 6;
			if(c>='M' && c<='O') result += 7;
			if(c>='P' && c<='S') result += 8;
			if(c>='T' && c<='V') result += 9;
			if(c>='W' && c<='Z') result += 10;
		}
		
		System.out.println(result);
	}

}
