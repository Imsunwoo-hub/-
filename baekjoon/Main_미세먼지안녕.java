package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_미세먼지안녕{

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int R = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		int T = Integer.parseInt(s[2]);
		int[][] ia = new int[R][C];
		int[][] temp;
		int[] air = new int[2];
		int idx = 0; 
		Queue<int[]> q  = new LinkedList<>();
		for(int i=0; i<R; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<C; j++){
				ia[i][j] = Integer.parseInt(t[j]);
				if(ia[i][j]==-1){
					air[idx] = i;
					idx++;
				}
			}
		}
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int result = 0;
		while(T>0) {
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(ia[i][j]>0) {
						q.offer(new int[] {i,j});
					}
				}
			}
			temp = new int[R][C];
			temp[air[0]][0] = -1;
			temp[air[1]][0] = -1;
			
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int i = curr[0];
				int j = curr[1];
				int cnt = 0;
				for(int d=0; d<di.length; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni>=0 && ni<R && nj>=0 && nj<C && ia[ni][nj]!=-1) {
						temp[ni][nj] += ia[i][j]/5;
						cnt++;
					}
				}
				temp[i][j] += ia[i][j]-(ia[i][j]/5)*cnt;
			}
			// 위쪽
			int t1 = 0;
			for(int j=C-1; j>0; j--) {
				if(j==1) {
					temp[air[0]][j] = 0;
				}
				else {
					if(j==C-1) t1 = temp[air[0]][j];
					temp[air[0]][j] = temp[air[0]][j-1];
				}
			}
			int t2 = 0;
			for(int i=0;  i<air[0]; i++) {
				if(i==air[0]-1) {
					temp[i][C-1] = t1;
				}
				else {
					if(i==0) t2 = temp[i][C-1];
					temp[i][C-1] = temp[i+1][C-1];
				}
			}
			int t3 = 0;
			for(int j=0; j<C-1; j++) {
				if(j==C-2) {
					temp[0][j] = t2;
				}
				else {
					if(j==0) t3 = temp[0][0];
					temp[0][j] = temp[0][j+1];
				}
			}
			for(int i=air[0]-1; i>0; i--) {
				if(i==1) {
					temp[i][0] = t3;
				}
				else {
					temp[i][0] = temp[i-1][0];
				}
			}
			// 아래쪽
			for(int j=C-1; j>0; j--) {
				if(j==1) temp[air[1]][j] = 0;
				else {
					if(j==C-1) t1 = temp[air[1]][j];
					temp[air[1]][j] = temp[air[1]][j-1];
				}
			}
			for(int i=R-1; i>air[1]; i--) {
				if(i==air[1]+1) temp[i][C-1] = t1;
				else {
					if(i==R-1) t2 = temp[i][C-1];
					temp[i][C-1] = temp[i-1][C-1];
				}
			}
			for(int j=0; j<C-1; j++) {
				if(j==C-2) temp[R-1][j] = t2;
				else {
					if(j==0) t3 = temp[R-1][j];
					temp[R-1][j] = temp[R-1][j+1];
				}
			}
			for(int i=air[1]+1; i<R-1; i++) {
				if(i==R-2) temp[i][0] = t3;
				//else if(i==air[1]+1) temp[i][0]=0;
				else {
					temp[i][0] = temp[i+1][0];
				}
				
			}
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					ia[i][j] = temp[i][j];
					if(T==1 && ia[i][j]!=-1) result += ia[i][j];  
				}
			}
			//for(int[] i :ia) System.out.println(Arrays.toString(i));
			T--;
		}
		/*
		 * int result = 0; for(int i=0; i<R; i++) { for(int j=0; j<C; j++) { result +=
		 * ia[i][j]; } }
		 */
		System.out.println(result);
	}

}
