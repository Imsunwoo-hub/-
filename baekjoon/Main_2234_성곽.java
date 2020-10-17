package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_2234_성곽 {
	
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int[][] map, v, room;
	static int N,M;
	static Stack<Integer> stack;
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s =br.readLine().split(" ");
		
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		v = new int[N][M];
		room = new int[N][M];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		int idx = 1;
		stack = new Stack<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(v[i][j]==0) {
					makeRoom(i,j,idx);
					idx++;
				}
			}
		}
		int[] cnt = new int[idx];
		int[][] gp = new int[idx][idx];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				cnt[room[i][j]]++;
				if(cnt[room[i][j]] > max) max = cnt[room[i][j]];
				for(int d=0; d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M) {
						if(room[i][j] != room[ni][nj]) {
							gp[room[i][j]][room[ni][nj]] = 1;
							gp[room[ni][nj]][room[i][j]] = 1;
						}
					}
				}
			}
		}
		int twoRoom = 0;
		for(int i=1; i<idx; i++) {
			for(int j=1; j<idx; j++) {
				if(gp[i][j]==1) {
					if(cnt[i]+cnt[j] > twoRoom) twoRoom = cnt[i]+cnt[j];
				}
			}
		}
		
		
		
		System.out.println(idx-1);
		System.out.println(max);
		System.out.println(twoRoom);
		
	}
	
	public static void makeRoom(int i, int j, int idx) {
		v[i][j] = 1;
		room[i][j] = idx;
		
		int n = map[i][j];
		stack.clear();
		String s = "";
		while(true) {
			if(n==0) break;
			stack.add(n%2);
			n /= 2;
		}
		while(!stack.isEmpty()) s+=stack.pop();
		while(s.length()<4) s = "0"+s;
		
		
		for(int d=0; d<4; d++) {
			if(s.charAt(d)=='0') {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0) {
					makeRoom(ni,nj,idx);
				}
			}
		}
		
	}

}
