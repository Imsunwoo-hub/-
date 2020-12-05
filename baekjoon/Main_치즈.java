package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_치즈 {

	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("res/input.txt"));
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];	
		
		int size = 0;
			
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 1) size++;
			}
		}
		
		int time = 0;
		int result = 0;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> dq = new LinkedList<>();
		
		while(size > 0) {
			time++;
			result = size;
			int[][] v = new int[N][M];
			v[0][0] = 1;
			q.offer(new int[] {0,0});
			
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				for(int d=0; d<4; d++) {
					int ni = curr[0]+di[d];
					int nj = curr[1]+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0) {
						v[ni][nj] = 1;
						if(map[ni][nj] == 0) q.offer(new int[] {ni,nj});
						else dq.offer(new int[] {ni,nj});
					}
				}
			}
			if(dq.isEmpty()) break;
			else {
				size -= dq.size();
				while(!dq.isEmpty()) {
					int curr[] = dq.poll();
					map[curr[0]][curr[1]] = 0;
				}
			}
		}
		
		System.out.println(time);
		System.out.println(result);
		
		
	}
}
