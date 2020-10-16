package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_주사위굴리기 {
	
	static int N,M;
	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int[][] map = new int[N][M];
		
		int[] diceIdx = new int[2];
		diceIdx[0] = Integer.parseInt(s[2]);
		diceIdx[1] = Integer.parseInt(s[3]);
		
		int[] dice = new int[6];
		
		int K = Integer.parseInt(s[4]);
		int[] commands = new int[K];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		s = br.readLine().split(" ");
		for(int i=0; i<K; i++) commands[i] = Integer.parseInt(s[i])-1;
		
		
		
		for(int i=0; i<K; i++) {
			init(map, dice, diceIdx, commands[i]);
			//System.out.println(Arrays.toString(dice));
		}

	}
	
	public static void init(int[][] map, int[] dice, int[] diceIdx, int d) {
		int ni = diceIdx[0]+di[d];
		int nj = diceIdx[1]+dj[d];
		if(ni<0 || nj<0 || ni>=N || nj>=M) return;
		diceIdx[0] = ni;
		diceIdx[1] = nj;
		move(dice, d);	
		copy(map, dice, diceIdx);
		System.out.println(dice[5]);
	}
	
	public static void copy(int[][] map, int[] dice, int[] diceIdx) {
		if(map[diceIdx[0]][diceIdx[1]]==0) {
			map[diceIdx[0]][diceIdx[1]]=dice[2];
		}
		else {
			dice[2] = map[diceIdx[0]][diceIdx[1]];
			map[diceIdx[0]][diceIdx[1]] = 0;
		}
	}
	
	public static void move(int[] dice, int d) {
		int[] temp = new int[6];
		for(int i=0; i<6; i++) temp[i] = dice[i];
		if(d==0) {
			dice[1] = temp[2];
			dice[2] = temp[3];
			dice[3] = temp[5];
			dice[5] = temp[1];
		}
		else if(d==1) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[3] = temp[2];
			dice[5] = temp[3];
		}
		else if(d==2) {
			dice[0] = temp[5];
			dice[2] = temp[0];
			dice[4] = temp[2];
			dice[5] = temp[4];
		}
		else {
			dice[0] = temp[2];
			dice[2] = temp[4];
			dice[4] = temp[5];
			dice[5] = temp[0];
		}
	}
}
