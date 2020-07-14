package swex;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_바이너리인덱스트리{
 
    public static void main(String[] args) throws Exception {
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc=1; tc<=T; tc++) {
             
            int N = sc.nextInt();
            int size = 1;
            while(true) {
                size *= 2;
                if(size>=N) break;
            }
            size = size*2;
            int M = sc.nextInt();
             
            int[] ia = new int[size+1];
            for(int i=0; i<N; i++) {
                ia[size/2+i] = sc.nextInt();
            }
            for(int i=size/2-1; i>=1; i-- ) {
                ia[i] = ia[i*2] + ia[i*2+1];
            }
            int[][] mi = new int[M][3]; 
             
            System.out.print("#"+tc+" ");
             
             
            for(int i=0; i<M; i++) {
                for(int j=0; j<3; j++) {
                    mi[i][j] = sc.nextInt();
                }
                if(mi[i][0]==1) {
                    int start = (size/2-1)+mi[i][1];
                    for(int k=start; k>=1; k/=2) {
                        ia[k] += mi[i][2];
                    }
                     
                }
                else {
                    int l = (size/2-1)+mi[i][1];
                    int r = (size/2-1)+mi[i][2];
                    int sum = 0;
                    while(true) {
                        if(l==r) {
                            sum += ia[l];
                            break;
                        }
                        if(r<l) break; 
                        if(l%2==1) {
                            sum += ia[l];
                            l = (l+1)/2;
                        }
                        else {
                            l = l/2;
                        }
                        if(r%2==0) {
                            sum += ia[r];
                            r = (r-1)/2;
                        }
                        else {
                            r = r/2;
                        }
                    }   
                    System.out.print(sum +" ");
                }
            }
             
            System.out.println();
        }
    }
 
}
