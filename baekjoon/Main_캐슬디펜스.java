package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main_캐슬디펜스 {
	
	static int N,M,D, result;
	static int[] ma, ta, map[];
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		D = Integer.parseInt(s[2]);
		
		ma = new int[M];
		ta = new int[3];
		map = new int[N][M];
		for(int i=0; i<M; i++) {
			ma[i] = i;
		}
		
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				if(t[j].equals("1")) list.add(new int[] {i,j});
				//map[i][j] = Integer.parseInt(t[j]);
			}
		}

		
		result = 0;
		comb(M,3);
		System.out.println(result);
		
	}
	
	public static void comb(int n, int r) {
		if(n<r) return;
		if(r==0) {
			int kill = 0;
			int count = 0;
			ArrayList<int[]> tlist = new ArrayList<>();
			ArrayList<int[]> mlist = new ArrayList<>();
			for(int[] l : list) tlist.add(l);
			
			while(tlist.size() > 0) {
				mlist.clear();
				
				for(int i=0; i<3; i++) {
					int x = N;
					int y = ta[i];
					int min = Integer.MAX_VALUE;
					int midx = 0;
					int bol=0;
					for(int k=0; k<tlist.size(); k++) {
						int td = Math.abs(x-tlist.get(k)[0]) + Math.abs(y-tlist.get(k)[1]);
						if(td<=D) {
							bol = 1;
							if(td<min) {
								min = td;
								midx = k;
							}
							else if(td == min) {
								if(tlist.get(k)[1] < tlist.get(midx)[1]) {
									min = td;
									midx = k;
								}
							}
						}
					}
					
					if(bol==1) mlist.add(tlist.get(midx));
				}
				
				//System.out.println(mlist.size());
				for(int[] ml : mlist) {
					
					for(int k=0; k<tlist.size(); k++) {
						if(ml[0] == tlist.get(k)[0] && ml[1]==tlist.get(k)[1]) {
							//System.out.println(Arrays.toString(ml));
							tlist.remove(k);
							//k--;
							kill++;
							break;
						}
					}
					
				}
				
				for(int k = 0; k<tlist.size(); k++) {
					int ni = tlist.get(k)[0]+1;
					if(ni < N) {
						tlist.set(k, new int[] {ni, tlist.get(k)[1]});
					}
					else {
						tlist.remove(k);
						k--;
					}
				}
				//for(int[] tl: tlist)System.out.println(Arrays.toString(tl));
				//System.out.println();
			}
			
			if(kill > result) result = kill;
			//System.out.println();
			return;
		}
		ta[r-1] = ma[n-1];
		comb(n-1,r-1);
		comb(n-1,r);
	}

}

