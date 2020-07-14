package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_모노미노도미노 {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] ia = new int[N][3];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			ia[i][0] = Integer.parseInt(s[0]);
			ia[i][1] = Integer.parseInt(s[1]);
			ia[i][2] = Integer.parseInt(s[2]);
		}
		
		int point = 0;
		int count = 0;
		int[][] map = new int[10][10];
		//이동 이동다한게 4~5 면 마지막줄 비우고 이동
		//꽉찬줄 비우기 
		for(int k=0; k<N; k++) {
			int[] curr = ia[k];
			
			if(curr[0]==1) {
				// 옆으로
				int ni = curr[1];
				int nj = curr[2];
				for(int j=curr[2]; j<10; j++) {
					if(map[ni][j]==1) break;
					nj = j;
				}
				map[ni][nj] = 1;
				solve1(map, ni, nj, 1, 1);
				solve2(map, 1);
				// 아래로
				ni = curr[1];
				nj = curr[2];
				for(int i=curr[1]; i<10; i++) {
					if(map[i][nj]==1) break;
					ni = i;
				}
				map[ni][nj] = 1;
				solve1(map, ni, nj, 2, 1);
				solve2(map, 2);
			}
			// ㅡ t = 2: 크기가 1×2인 블록을 (x, y), (x, y+1)에 놓은 경우
			else if(curr[0]==2) {
				//옆
				int ni = curr[1];
				int nj = curr[2]+1;
				for(int j=nj; j<10; j++) {
					if(map[ni][j]==1) break;
					nj = j;
				}
				map[ni][nj-1] = 1;
				map[ni][nj] = 1;
				solve1(map, ni, nj, 1, 2);
				solve2(map, 1);
				//아래
				ni = curr[1];
				nj = curr[2]+1;
				for(int i=curr[1]; i<10; i++) {
					if(map[i][nj]==1 || map[i][nj-1]==1) break;
					ni = i;
				}
				solve1(map, ni, nj, 2, 2);
				solve2(map, 2);
			}
			// | t = 3: 크기가 2×1인 블록을 (x, y), (x+1, y)에 놓은 경우
			else if(curr[0]==3) {
				int ni = curr[1]+1;
				int nj = curr[2];
				for(int j=nj; j<10; j++) {
					if(map[ni][j]==1 || map[ni-1][j]==1) break;
					nj = j;
				}
				map[ni-1][nj] = 1;
				map[ni][nj] = 1;
				solve1(map, ni, nj, 1, 3);
				solve2(map, 1);
				
				ni = curr[1]+1;
				nj = curr[2];
				for(int i=ni; i<10; i++) {
					if(map[i][nj]==1) break;
					ni = i;
				}
				map[ni-1][nj] = 1;
				map[ni][nj] = 1;
				solve1(map, ni, nj, 2, 3);
				solve2(map, 2);
			}
			
		}
		
		
		System.out.println(point);
		System.out.println(count);

	}
	
	public static void solve1(int[][] map, int x, int j, int k, int t) {
		
	}
	
	public static void solve2(int[][] map, int k) {
		while(true) {
			int bol = 0;
			if(k==1) {
				for(int i=0; i<4; i++) {
					if(map[i][5]==1) {
						bol=1;
						break;
					}
				}
				if(bol==0) break;
				for(int j=9; j>=4; j--) {
					for(int i=0; i<4; i++) {
						map[i][j] = map[i][j-1];
					}
				}
			}
			else {
				for(int j=0; j<4; j++) {
					if(map[5][j]==1) {
						bol=1;
						break;
					}
				}
				if(bol==0) break;
				for(int i=9; i>=4; i--) {
					for(int j=0; j<4; j++) {
						map[i][j] = map[i-1][j];
					}
				}
			}
		}
	}

}
