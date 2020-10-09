package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] s= br.readLine().split(" ");
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(s[i]);
			if(map.containsKey(n)) map.put(n, map.get(n)+1);
			else map.put(n, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		s = br.readLine().split(" ");
		
		for(int i=0; i<M; i++) {
			int n = Integer.parseInt(s[i]);
			if(map.containsKey(n)) bw.append(map.get(n)+" ");
			else bw.append("0 ");
		}
		bw.flush();
	}

}
