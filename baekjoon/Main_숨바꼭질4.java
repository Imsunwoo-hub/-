package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main_숨바꼭질4 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int[] v = new int[100001];
		int[] p = new int[100001];
		
		q.offer(new int[] {N, 0});
		
		Stack<Integer> stack = new Stack<>();
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int cnt = curr[1];
			if(x==K) {
				System.out.println(cnt);
				
				int idx = x;
				stack.push(idx);
				while(idx != N) {
					stack.push(idx = p[idx]);
				}
				
				break;
			}
				if(x+1 < 100001 && v[x+1]==0) {
					q.offer(new int[] {x+1, cnt+1,});
					v[x+1] = 1;
					p[x+1] = x;
				}
				if(x-1 >= 0 && v[x-1]==0) {
					q.offer(new int[] {x-1,cnt+1});
					v[x-1] = 1;
					p[x-1] = x;
				}
				if(2*x < 100001 && v[x*2]==0) {
					q.offer(new int[] {(2*x), (cnt+1)});
					v[2*x] = 1;
					p[2*x] = x;
				}
			}
		
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
		
			
		}

	}


