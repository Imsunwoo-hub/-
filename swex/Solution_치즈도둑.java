package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_치즈도둑 {
     
    public static int N, v[][], ia[][];
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new int[N][N];
            int max= 0;
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                    if(max<ia[i][j]) max = ia[i][j];
                    }
            }
            int count=0;
            int result = 0;
            while(count<max) {
                v = new int[N][N];
                int c = 0;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(v[i][j]==0 && ia[i][j]>count) {
                            c++;
                            v[i][j]=1;
                            dfs(i,j, count);
                        }
                    }
                }
                if(c>result) result = c;
                count++;
             
            }
            System.out.println("#" + tc+ " "+result);
        }
     
    }
     
    public static void dfs(int i, int j, int c) {
         
        for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
             
            if(ni>=0 && ni<N && nj>=0 && nj<N && v[ni][nj]==0 && ia[ni][nj]>c ) {
                v[ni][nj] = 1;
                dfs(ni,nj,c);
            }
        }
    }
 
}

