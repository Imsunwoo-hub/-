package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Tree {
	ArrayList<Integer> list = new ArrayList<>();
}


public class Main_줄세우기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] count = new int[N+1];
		Tree[] tlist = new Tree[N+1];
		
		for(int i=0; i<M; i++) {
			String[] t = br.readLine().split(" ");
			int a = Integer.parseInt(t[0]);
			int b = Integer.parseInt(t[1]);
			if(tlist[a] == null) {
				Tree tree = new Tree();
				tree.list.add(b);
				tlist[a] = tree;
			}
			else {
				tlist[a].list.add(b);
			}
			count[b]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(count[i]==0) q.offer(i);
		}
		Queue<Integer> result = new LinkedList<>();
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(tlist[curr] != null) {
				for(int i=0; i<tlist[curr].list.size(); i++) {
					count[tlist[curr].list.get(i)]--;
					if(count[tlist[curr].list.get(i)]==0) {
						q.offer(tlist[curr].list.get(i));
					}
					tlist[curr].list.remove(i);
					i--;
				}
			}
			result.offer(curr);
		}
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
		System.out.println();

	}

}
