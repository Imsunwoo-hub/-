package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main_소수경로 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			
			int bol = 0;
			q.clear();
			
			q.offer(new int[] {A,0});
			
			HashMap<Integer, Integer> v = new HashMap<>();
			
			v.put(A, 1);
			
			while(!q.isEmpty()) {
				
				int[] curr = q.poll();
				
				if(curr[0]==B) {
					System.out.println(curr[1]);
					bol = 1;
					break;
				}
				
				String temp = curr[0]+"";
				
				for(int i=0; i<temp.length(); i++) {
					char[] ca = temp.toCharArray();
					int j=0;
					if(i==0) j=1;
					for(; j<=9; j++) {
						ca[i] = (char)(j+'0');
						
						String t = "";
						for(int k=0; k<4; k++) {
							t += ca[k]; 
						}
						int num = Integer.parseInt(t);
						if(!v.containsKey(num) && check(num)) {
							v.put(num, 1);
							q.offer(new int[] {num, curr[1]+1});
						}
					}
					
				}
			}
			
			if(bol == 0)System.out.println("Impossible");
		}

	}
	
	public static boolean check(int num) {
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}

}
