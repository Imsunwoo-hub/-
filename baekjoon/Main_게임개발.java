package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_게임개발 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		int[] time = new int[N+1];
		int[] cnt = new int[N+1];
		int[] rtime = new int[N+1];
		for(int i=1; i<=N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<s.length-1; j++) {
				if(j==0) {
					time[i] = Integer.parseInt(s[j]);
					rtime[i] = Integer.parseInt(s[j]);
				}
				else {
					int x = Integer.parseInt(s[j]);
					list[x].add(i);
					cnt[i]++;
				}
			}
		}
		//System.out.println(Arrays.toString(cnt));
		
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(cnt[i]==0) {
				
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			result[x] = rtime[x];
			//System.out.println("x="+x);
			//result.add(time[x]);
			//result.add(x);
			for(int i:list[x]) {
				cnt[i]--;
				rtime[i] = Math.max(rtime[i], rtime[x]+time[i]);
				//time[i] += time[x];
				if(cnt[i]==0) {
					q.offer(i);
				}
			}
		}
		
		for(int i=1; i<=N; i++) System.out.println(result[i]);

	}

}
