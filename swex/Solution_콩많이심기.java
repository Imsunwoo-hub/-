package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_콩많이심기 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int[][] ia = new int[Integer.parseInt(s[0])][Integer.parseInt(s[1])];
            int count = 0;
            int[] di = {0,0,-2,2};
            int[] dj = {2,-2,0,0};
            for(int i=0; i<ia.length; i++) {
                for(int j=0; j<ia[0].length; j++) {
                    if(ia[i][j]==0) {
                        ia[i][j] = 1;
                        count++;
                        for(int d=0; d<di.length; d++) {
                            int ni = i+di[d];
                            int nj = j+dj[d];
                            if(ni>=0 && ni<ia.length && nj>=0 && nj<ia[0].length && ia[ni][nj]==0) {
                                ia[ni][nj] = 1;
                            }
                        }
                    }
                     
                }
            }
            System.out.println("#"+tc+" "+count);   
        }
    }
}
