package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		String[] sa = new String[N+1];
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String p = br.readLine();
			sa[i] = p;
			map.put(p, i);
		}
		
		for(int i=0; i<M; i++) {
			String q = br.readLine();
			if(q.charAt(0) >= '0' && q.charAt(0) <='9' ) {
				System.out.println(sa[Integer.parseInt(q)]);
			}
			else {
				System.out.println(map.get(q));
			}
		}
		
	}

}
