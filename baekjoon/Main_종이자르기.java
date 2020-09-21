package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_종이자르기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		
		row.add(0);
		row.add(N);
		col.add(0);
		col.add(M);
		
		for(int i=0; i<K; i++) {
			s = br.readLine().split(" ");
			if(Integer.parseInt(s[0])==0) {
				col.add(Integer.parseInt(s[1]));
			}
			else {
				row.add(Integer.parseInt(s[1]));
			}
		}
		
		Collections.sort(row);
		Collections.sort(col);
		
		int result = 0;
		
		for(int i=0; i<row.size()-1; i++) {
			for(int j=0; j<col.size()-1; j++) {
				int temp = (row.get(i+1)-row.get(i)) * (col.get(j+1)-col.get(j));
				result = Math.max(result, temp);
			}
		}
		
		
		System.out.println(result);
	}

}
