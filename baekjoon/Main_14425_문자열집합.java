package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			map.put(t, t);
		}
		
		int result = 0;
		
		for(int i=0; i<M; i++) {
			String t = br.readLine();
			if(map.containsKey(t)) result ++;
		}
		System.out.println(result);
	}	

}
