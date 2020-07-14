package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Solution_등산로조성 {
     
    public static int count,N,ia[][], K, v[][], tempc, max, bol;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
 
    public static void main(String[] args) throws Exception {
     
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] t = br.readLine().split(" ");
            N = Integer.parseInt(t[0]);
            K = Integer.parseInt(t[1]);
            ia = new int[N][N];
            v = new int[N][N];
            max = Integer.MIN_VALUE;
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                for(int j =0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(s[j]);
                    if(ia[i][j] > max) {
                        list.clear();
                        max = ia[i][j];
                        list.add(new int[] {i,j});
                    }
                    else if(ia[i][j]==max) list.add(new int[] {i,j});
                }
            }
            int result = 0;
            for(int[] l:list) {
                //System.out.println(l[0]+ " "+l[1]);
                bol = 0;
                count = 0;
                v[l[0]][l[1]] = 1;
                dfs(l[0], l[1], 1);
                v[l[0]][l[1]] = 0;
                if( count > result ) result = count;
            }
             
            /*for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(ia[i][j] != max) {
                        bol = 0;
                        count = 0;
                        v[i][j] = 1;
                        dfs(i,j,1);
                        v[i][j] = 0;
                        if(count > result ) result = count;
                    }
                }
            }*/
            System.out.println("#"+tc+" "+result);
        }
         
    }
     
    public static void dfs(int i, int j, int c) {
         
    /*  if(ia[i][j]==max) {
            for(int[] a: ia) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
            if(c>count) count = c;
            return;
        }*/
         
        for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && nj>=0 && ni<N && nj<N && v[ni][nj]== 0 ) {
                 
                if(ia[ni][nj] < ia[i][j]) {
                    v[ni][nj] = 1;
                    dfs(ni,nj,c+1);
                    v[ni][nj] = 0;
                }
                else {
                    if( ia[ni][nj]-K < ia[i][j] && bol == 0) {
                     
                    for(int k=1; k<=K; k++) {
                        if(ia[ni][nj]-k >= ia[i][j]) continue;
                        bol = 1;
                        ia[ni][nj] -= k;
                        v[ni][nj] = 1;
                        dfs(ni, nj, c+1);
                        v[ni][nj] = 0;
                        bol = 0;
                        ia[ni][nj] += k;
                        }
                    }
                }
                /*v[ni][nj] =1;
                if(ia[ni][nj] > ia[i][j]) {
                    dfs(ni,nj,c+1);
                }
                else if(ia[ni][nj]-K > ia[i][j] && bol == 0) {
                    for(int k=1; k<=K; k++) {
                        bol =1;
                        ia[ni][nj] -= k;
                        dfs(ni, nj, c+1);
                        bol = 0;
                        ia[ni][nj] += k;
                    }
                }
                v[ni][nj] = 0;*/
            }
        }
        if(c > count) count = c;
        return;
    }
 
}

