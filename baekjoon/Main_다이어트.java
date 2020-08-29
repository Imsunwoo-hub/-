package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_다이어트 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(true) {
			if(end==start+1) {
				if(end*end - start*start > G) break;
			}
			
			if(end*end - start*start > G) {
				start++;
			}
			else if (end*end - start*start == G) {
				list.add(end);
				start++;
			}
			else {
				end++;
			}
		}
		
		if(list.size()==0) System.out.println("-1");
		else {
			for(int l:list) System.out.println(l);
		}

	}

}
