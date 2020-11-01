package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		int cnt = 0;
		while(!list.isEmpty()) {
			
			for(int i=0; i<list.size(); i++) {
				cnt++;
				if(cnt==K) {
					cnt = 0;
					result.add(list.get(i));
					list.remove(i);
					i--;
				}
			}
		}
		
		String answer = "<";
		for(int i=0 ; i<result.size(); i++) {
			if(i==result.size()-1) {
				answer += result.get(i)+">";
			}
			else {
				answer += result.get(i)+", ";
			}
		}
		
		System.out.println(answer);
	}

}
