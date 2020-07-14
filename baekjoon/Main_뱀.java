package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_뱀 {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] ia  = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			String[] s = br.readLine().split(" ");
			ia[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 100;
		}
		int L = Integer.parseInt(br.readLine());
		ArrayList<String[]> l = new ArrayList<>();
		for(int i=0; i<L; i++) {
			 String[] sa = br.readLine().split(" ");
			 l.add(sa);
		}
		int result = 0;
		int[] bamh = {0,0};
		Queue<int[]> bamt = new LinkedList<>();
		int goi =  0;
		int goj =  1;
		int go  =  1;
		int bl = 1;
		/*for(int[] a:ia) System.out.println(Arrays.toString(a));
		System.out.println();*/
		
		while(true) {
			
			result++;
			//System.out.println(result);
			
			
			int ni = bamh[0]+goi;
			int nj = bamh[1]+goj;
			if(ni<0 || nj<0 || ni>=N || nj>=N || ia[ni][nj]==1) break;
			
			
			if(ia[ni][nj]==100) {
				bamt.offer(new int[] {bamh[0],bamh[1]});
				ia[bamh[0]][bamh[1]] = 1;
				bamh[0] += goi;
				bamh[1] += goj;
				ia[bamh[0]][bamh[1]] = 1;
				
			}
			
			else if(ia[ni][nj]==0) {
				bamt.offer(new int[] {bamh[0],bamh[1]});
				
				ia[bamt.peek()[0]][bamt.peek()[1]] = 0;
				bamt.poll();
				
				bamh[0] += goi;
				bamh[1] += goj;
				ia[bamh[0]][bamh[1]] = 1;
			}
			if(l.size() !=0 && result == Integer.parseInt(l.get(0)[0])) {
				String t = l.get(0)[1];
				switch(go) {
				case 1: 
					if(t.equals("L")) {
						goi = -1;
						goj = 0;
						go = 4;
					}
					else {
						goi = 1;
						goj = 0;
						go = 2;
					}
					break;
				case 2: 
					if(t.equals("L")) {
						goi = 0;
						goj = 1;
						go = 1;
					}
					else {
						goi = 0;
						goj = -1;
						go = 3;
					}
					break;
				case 3: 
					if(t.equals("L")) {
						goi = 1;
						goj = 0;
						go = 2;
					}
					else {
						goi = -1;
						goj = 0;
						go = 4;
					}
					break;
				case 4: 
					if(t.equals("L")) {
						goi = 0;
						goj = -1;
						go = 3;
					}
					else {
						goi = 0;
						goj = 1;
						go = 1;
					}
					break;
				}
				l.remove(0);
			}
			
			
			/*for(int[] a:ia) System.out.println(Arrays.toString(a));
			System.out.println();*/
			
		}
		
		
		System.out.println(result);
	}

}
