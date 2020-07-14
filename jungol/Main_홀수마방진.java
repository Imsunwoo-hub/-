package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_홀수마방진 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        int[][] ia = new int[N][N];
         
        int x = 0;                     
        int y = N/2;            
                           
        int end =N*N;             
              
        for (int i = 1; i <= end; i++) {  
            ia[x][y] = i;            
            if (i%N == 0) {       
                x++;                 
            }
            else {
               x--;
               y--;             
               if (x < 0) x = N-1;     
               if (y < 0) y = N-1;     
             }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(ia[i][j]+" ");
            }
            System.out.println();
        }
    }
     
 
}

