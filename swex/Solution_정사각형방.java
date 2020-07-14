package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_정사각형방 {
     
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
    public static int N, ia[][], v[][], count, min;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new int[N][N];
            int result = 0;
            min = 0;
            for(int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(s[j]);
                }
            }
            for(int i=0; i<N;  i++) {
                for(int j=0; j<N; j++) {
                    count = 0;
                    dfs(i,j);
                    if(count > result) {
                        result = count;
                        min = ia[i][j];
                    }else if(count==result) {
                            if(min>ia[i][j]) {
                            min = ia[i][j];
                        }
                    }
                }
            }
            System.out.println("#"+tc+" "+ min+" "+result);
        }
    }
    public static void dfs(int i, int j) {
        count++;
         
        for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && ni<N && nj>=0 && nj<N &&  ia[ni][nj] == ia[i][j]+1) {
                dfs(ni,nj);
            }
        }
    }
}

