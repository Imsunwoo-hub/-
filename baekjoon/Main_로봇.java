package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_로봇 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][M];
		int[][] v = new int[N][M];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			s = br.readLine().split(" ");
			map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
		int[] robot = new int[2];
		s = br.readLine().split(" ");
		robot[0] = Integer.parseInt(s[0]);
		robot[1] = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] dlist = new int[s.length];
		
		for(int i=0; i<dlist.length; i++) {
			dlist[i] = Integer.parseInt(s[i])-1;
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {robot[0], robot[1]});
		int d = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			robot[0] = curr[0];
			robot[1] = curr[1];
			v[curr[0]][curr[1]] = 1;
			
			int ni = curr[0]+di[dlist[d]];
			int nj = curr[1]+dj[dlist[d]];
			if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0 && map[ni][nj]==0) {
				q.offer(new int[] {ni,nj});
				continue;
			}
			
			for(int i=0; i<4; i++) {
				d = (d+1)%4;
				ni = curr[0]+di[dlist[d]];
				nj = curr[1]+dj[dlist[d]];
				if(ni>=0 && nj>=0 && ni<N && nj<M && v[ni][nj]==0 && map[ni][nj]==0) {
					q.offer(new int[] {ni,nj});
					break;
				}
			}
		}
				
		System.out.println(robot[0]+" "+robot[1]); 
	}

}
