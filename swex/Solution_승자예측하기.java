package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_승자예측하기 {
     
    public static long N, result;
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            N = Long.parseLong(br.readLine())-1;
            boolean bob = true;
            int base = 2;
            while(N>0) {
                N -= Math.pow(4, (base++/2));
                bob = !bob;
            }
            System.out.println("#"+tc+" "+ (bob ? "Bob" : "Alice"));
        }
    }
 
     
}

