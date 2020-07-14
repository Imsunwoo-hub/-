package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_보급로 {
     
    public static int N, ia[][], result, v[][], dp[][];
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new int[N][N];
            v = new int[N][N];
            dp = new int[N][N];
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    ia[i][j] = s.charAt(j)-'0';
                    dp[i][j] = Integer.MAX_VALUE/2;
                }
            }
             
            bfs(0,0);
            System.out.println("#"+tc+" "+dp[N-1][N-1]);
        }
 
    }
     
    public static void bfs(int i, int j) {
        v[i][j] = 0;
        dp[i][j] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int ci = curr[0];
            int cj = curr[1];
            for(int d=0; d<di.length; d++) {
                int ni = ci+di[d];
                int nj = cj+dj[d];
                if(ni>=0 && ni<N && nj>=0 && nj<N) {
                    if(v[ni][nj]==0) {
                        v[ni][nj] = 1;
                        dp[ni][nj] = dp[ci][cj]+ia[ni][nj];
                        q.offer(new int[] {ni,nj});
                    }
                    else {
                        if(dp[ni][nj]>dp[ci][cj]+ia[ni][nj]) {
                            dp[ni][nj] = dp[ci][cj]+ia[ni][nj];
                            q.offer(new int[] {ni,nj});
                        }
                    }
                }
            }
        }
    }
     
     
}

