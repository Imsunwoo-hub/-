package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_러시아국기같은깃발 {
 
    public static void main(String[] args) throws Exception {
         
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            char[][] ca = new char[N][M];
             
            for(int i =0; i<N; i++) {
                String t = br.readLine();
                for(int j=0; j<M; j++) {
                    ca[i][j] = t.charAt(j);
                }
            }
             
            int result = Integer.MAX_VALUE;
             
            for(int i=1; i<N; i++) {
                for(int j=1; j<N; j++) {
                    for(int k=1; k<N; k++) {
                        if(i+j+k==N) {
                            int temp = 0;
                            for(int a=0; a<i; a++) {
                                for(int b=0; b<M; b++) {
                                    if(ca[a][b] != 'W') temp++;
                                }
                            }
                            for(int a=i; a<i+j; a++) {
                                for(int b=0; b<M; b++) {
                                    if(ca[a][b] != 'B') temp++;
                                }
                            }
                            for(int a=i+j; a<N; a++) {
                                for(int b=0; b<M; b++) {
                                    if(ca[a][b] != 'R') temp++;
                                }
                            }
                             
                            if(temp<result) result = temp;
                        }
                    }
                }
            }
             
            System.out.println("#"+tc+" "+result);
        }
         
    }
 
}

