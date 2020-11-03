package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_세로읽기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			list.add(s);
			if(s.length() > max) max = s.length();
		}
		String result = "";
		for(int j=0; j<max; j++ ) {
			for(int i=0; i<5; i++) {
				if(list.get(i).length() > j) {
					result += list.get(i).charAt(j);
				}
			}
		}
		System.out.println(result);
	}

}
