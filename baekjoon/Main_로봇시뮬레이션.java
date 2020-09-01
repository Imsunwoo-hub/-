package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_로봇시뮬레이션 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		
		int[][] map = new int[B][A];
		
		s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] robots = new int[N][3];
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1]);
			String d = s[2];
			map[(B-y)][x] = i+1;
			robots[i][0] = B-y;
			robots[i][1] = x;
			if(d.equals("N")) robots[i][2] = 0;
			else if(d.equals("E")) robots[i][2] = 1;
			else if(d.equals("S")) robots[i][2] = 2;
			else robots[i][2] = 3;
			
		}
		
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		
		for(int k=0; k<M; k++) {
			s = br.readLine().split(" ");
			int robot = Integer.parseInt(s[0])-1;
			String move = s[1];
			int count = Integer.parseInt(s[2]);
			if(move.equals("L")) {
				robots[robot][2] = (4+(robots[robot][2]-(count%4)))%4;
			}
			else if(move.equals("R")) {
				robots[robot][2] = (robots[robot][2]+count)%4;
			}
			else {
				for(int i=1; i<=count; i++) {
					int ni = robots[robot][0] + di[robots[robot][2]];
					int nj = robots[robot][1] + dj[robots[robot][2]];
					if(ni< 0 || nj<0 || ni>=B || nj>=A) {
						System.out.println("Robot "+(robot+1)+" crashes into the wall");
						return;
					}
					else if(map[ni][nj] != 0) {
						System.out.println("Robot "+(robot+1)+" crashes into robot "+map[ni][nj]);
						return;
					}
					else {
						map[robots[robot][0]][robots[robot][1]] = 0;
						map[ni][nj] = robot+1;
						robots[robot][0] = ni;
						robots[robot][1] = nj;
					}
				}
			}
		}
		
		System.out.println("OK");

	}

}
