package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_쉬운거스름돈 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] ia = {50000,10000,5000,1000,500,100,50,10};
            System.out.println("#"+tc);
            for(int i=0; i<ia.length; i++) {
                System.out.print(N/ia[i]+" ");
                N = N%ia[i];
            }
            System.out.println();
             
        }
    }
}

