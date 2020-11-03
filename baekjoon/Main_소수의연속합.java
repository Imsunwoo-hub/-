package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_소수의연속합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=2; i<=N; i++) {
			int bol = 0;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					bol=1;
					break;
				}
			}
			if(bol==0) list.add(i);
		}
		//System.out.println(list);
		int result = 0;
		int l=0; 
		int r=0;
		int temp = 0;
		while(true) {
			if(temp > N) {
				temp -= list.get(l++);
				if(temp == N) result++;
			}
			else if(r==list.size()) break;
			else {
				temp += list.get(r++);
				if(temp == N) result++;
			}
			
		}
		
		System.out.println(result);
	}

}
