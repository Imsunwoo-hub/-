package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_홈방범서비스 {
 
    static int result, N, M, ia[][];
     
    public static void main(String[] args) throws Exception{
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
             
            ia = new int[N][N];
             
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" "); 
                for(int j=0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                }
            }
            result = 1;
            for(int k=2; k<=N+1; k++ ) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        bfs(i,j,k);
                    }
                }
            }
            System.out.println("#"+tc+" "+result);
        }
 
    }
     
    public static void bfs(int i, int j, int k) {
        int [][] v= new int[N][N];
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        int count = 0;
        int K = k*k+(k-1)*(k-1);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j,0});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(v[curr[0]][curr[1]]==0) {
                v[curr[0]][curr[1]]=1;
                 
                if(ia[curr[0]][curr[1]] == 1) count++;
                if(curr[2]==k-1) continue;
                for(int d=0; d<di.length; d++) {
                    int ni = curr[0]+di[d];
                    int nj = curr[1]+dj[d];
                    if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]==0) {
                        q.offer(new int[] {ni,nj,curr[2]+1});
                    }
                }
            }
        }
        int temp = count*M - K;
        if(temp >=0) {
            if(result < count) result = count;
        }
    }
 
}

