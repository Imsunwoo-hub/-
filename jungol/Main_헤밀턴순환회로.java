package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main_헤밀턴순환회로 {
 
    public static int N, result, v[], ia[][];
     
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
         
        v = new int[N];
        ia = new int[N][N];
        result = Integer.MAX_VALUE;
         
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                ia[i][j] = Integer.parseInt(s[j]);
            }
        }
         
        dfs(0,0,0);
        if(result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
     
    public static void dfs(int i, int c, int count) {
        if(count==N-1) {
            if(ia[i][0] == 0 ) return;
            c = c+ia[i][0];
            if(c != 0 && c<result) result = c;
            return;
        }
         
        for(int j=1; j<N; j++) {
            if(i != j && v[j] != 1 && c+ia[i][j] < result && ia[i][j]!=0) {
                v[j] = 1;
                 
                dfs(j,c+ia[i][j],count+1);
                 
                v[j] = 0;
            }
        }
    }
 
}

