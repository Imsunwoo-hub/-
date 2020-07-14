package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_사람네트워크2 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int INF = Integer.MAX_VALUE/2;
            int[][] ia = new int[N][N];
            for(int i=0; i<s.length-1; i++) {
                ia[i/N][i%N] = Integer.parseInt(s[i+1]);
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i!=j && ia[i][j]==0) {
                        ia[i][j] = INF;
                    }
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    for(int k=0; k<N; k++) {
                        ia[i][j] = Math.min(ia[i][j], ia[i][k]+ia[k][j]);
                    }
                }
            }
            Long cc = Long.MAX_VALUE;
            for(int i=0; i<N; i++) {
                Long t = 0L;
                for(int j=0; j<N; j++) {
                    t += ia[i][j];
                }
                if(t<cc) cc=t;
            }
            System.out.println("#"+tc+" "+cc);
        }
    }
}

