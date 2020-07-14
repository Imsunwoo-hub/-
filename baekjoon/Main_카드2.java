package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_카드2 {

	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int N = Integer.parseInt(s);
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			//if(q.size()==1) break;
			int i = q.poll();
			q.offer(i);
		}
	
		System.out.println(q.poll());
	}

}
