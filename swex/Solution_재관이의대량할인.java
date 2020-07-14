package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_재관이의대량할인 {
     
    public static void main(String[] args) throws Exception {
         
     
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
             
            int total = 0;
            int N = Integer.parseInt(br.readLine());
            int[] ia = new int[N];
            String [] s = br.readLine().split(" ");
            for(int i =0; i<N; i++) {
                ia[i] = Integer.parseInt(s[i]);
                total += ia[i];
            }
             
            Arrays.sort(ia);
            for(int i=N-3; i>=0; i-=3) {
                total -= ia[i];
            }
             
             
            System.out.println("#"+tc+" " + total);
             
        }
    }
 
}
