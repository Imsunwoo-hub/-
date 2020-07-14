package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_수진이의펠린드롬 {
 
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            char[] ca = br.readLine().toCharArray();
            int N = ca.length;
             
            Arrays.sort(ca);
            int len = 1;
            int C=0;
            while(len<=N) {
                for(int i=0; i<N; i++) {
                    String temp = "";
                    if(i+len>N) break;
                    for(int j=i; j<i+len; j++) {
                        temp += ca[j];
                    }
                    String t = "";
                    for(int j=temp.length()-1; j>=0; j--) {
                        t += temp.charAt(j);
                    }
                     
                    if(temp.equals(t)) C++;
                }
                len++;
            }
             
             
            System.out.println("#"+tc+" "+C);
        }
 
    }
     
     
     
 
}

