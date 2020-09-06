package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_Crazy_aRcade_Good {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int[] start = new int[2];
		start[0] = Integer.parseInt(s[0])-1;
		start[1] = Integer.parseInt(s[1])-1;
		int[][] v = new int[10][10];
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			String t = br.readLine();
			for(int j=0; j<10; j++) {
				if(t.charAt(j)=='o') list.add(new int[] {i,j});
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		q.offer(new int[] {start[0], start[1], 0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			if(v[curr[0]][curr[1]]==0) {
				v[curr[0]][curr[1]] = 1;
				
				if(check(curr[0],curr[1],list)) {
					System.out.println(curr[2]);
					break;
				}
			}
			
			for(int d=0; d<4; d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				
				if(ni>=0 && nj >=0 && ni<10 && nj<10 && v[ni][nj]==0) {
					q.offer(new int[] {ni,nj,curr[2]+1});
				}
			}
			
		}
		
	}
	
	public static boolean check(int i, int j, ArrayList<int[]> list) {
		
		for(int[] l:list) {
			if(l[0]==i || l[1]==j ) return false;
		}
		
		return true;
	}

}
