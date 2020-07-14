package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main_내리막길 {
     
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
    public static int[][] ia, mj;
    public static int M,N,result;
 
    public static void main(String[] args) throws Exception {
         
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //String[] s = br.readLine().split(" ");
        M = sc.nextInt();
        N = sc.nextInt();
        ia = new int[M][N];
        mj = new int[M][N];
        for(int i=0; i<M; i++) {
             
            for(int j=0; j<N; j++) {
                ia[i][j] = sc.nextInt();
                mj[i][j] = -1;
            }
        }
        mj[M-1][N-1] = 1;
        dfs(0,0);
        result = mj[0][0];
        System.out.println(result);
    }
     
    public static int dfs(int i, int j) {
        mj[i][j] = 0;
        for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && nj>=0 && ni<M && nj<N && ia[i][j] > ia[ni][nj]) {
                if(mj[ni][nj]==-1) {
                    mj[i][j] += dfs(ni,nj);
                }
                else {
                    mj[i][j] += mj[ni][nj];
                }
                 
            }
        }
        return mj[i][j];
    }
     
     
 
}
