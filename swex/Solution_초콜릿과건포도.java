package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_초콜릿과건포도 {
 
    public static void main(String[] args) throws Exception {
     
         
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
             
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
             
            int[][] ia = new int[N][M];
            int[][][][] dp = new int[51][51][51][51];
             
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                for(int j=0; j<M; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                }
            }
            for(int i=0; i<51; i++) {
                for(int j=0; j<51; j++) {
                    for(int k=0; k<51; k++) {
                        for(int l=0; l<51; l++) {
                            dp[i][j][k][l] = 1000000000;
                        }
                    }
                }
            }
             
             
            int result = solve(0,0,N,M,ia,dp);
             
            System.out.println("#"+tc+" "+result);
             
        }
    }
     
    public static int solve(int i, int j, int n, int m, int[][] ia, int[][][][] dp) {
        if(n==1 && m==1 ) return 0;
         
        int sum = 0;
        for(int a=i; a<i+n; a++) {
            for(int b=j; b<j+m; b++) {
                sum += ia[a][b];
            }
        }
         
        for (int a = 1; a < n; a++) {
            if(dp[i][j][a][m] ==1000000000) {
                dp[i][j][a][m] = solve(i,j,a,m,ia,dp);
            }
            if(dp[i+ a][j][n- a][m] ==1000000000) {
                dp[i+ a][j][n- a][m] = solve(i+a , j, n-a , m, ia,dp);
            }
            int min = sum + dp[i][j][a][m] + dp[i+ a][j][n-a][m];
            dp[i][j][n][m] = Math.min(dp[i][j][n][m], min);
        }
         
        for (int b=1; b<m; b++) {
         
            if(dp[i][j][n][b] ==1000000000) {
                dp[i][j][n][b] = solve(i,j,n,b,ia,dp);
            }
            if(dp[i][j + b][n][m - b] ==1000000000) {
                dp[i][j + b][n][m - b] = solve(i, j + b, n, m - b,ia,dp);
            }
             
            int min = sum + dp[i][j][n][b] + dp[i][j + b][n][m - b];
            dp[i][j][n][m] = Math.min(dp[i][j][n][m], min);
        }
         
        return dp[i][j][n][m];
    }
 
}

