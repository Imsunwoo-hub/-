package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11725_트리의부모찾기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] tree = new ArrayList[100001];
		
		for(int i=1; i<100001; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			tree[a].add(b);
			tree[b].add(a);
		}
		
		int[] v = new int[100001];
		int[] ia = new int[100001];
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		v[1] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i : tree[now]) {
				if(v[i]==0) {
					v[i] = 1;
					ia[i] = now;
					q.offer(i);
				}
			}
		}
		
		for(int i=2; i<100001; i++) {
			if(ia[i] != 0)System.out.println(ia[i]);
		}
	}

}
