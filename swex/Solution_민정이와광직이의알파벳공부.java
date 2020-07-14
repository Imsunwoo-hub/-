package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_민정이와광직이의알파벳공부 {
     
    static int result;
    static int[] d;
 
    public static void main(String[] args) throws Exception  {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            String[] doc = new String[N];
            d = new int[N];
            for(int i=0; i<N; i++) {
                doc[i] = br.readLine();
            }
            result = 0;
            powerset(0,N, doc);
            System.out.println("#"+ tc+ " "+ result);
             
        }
 
    }
     
    public static void powerset(int c, int n, String[] doc) {
        if(c==n) {
            int[] alpa = new int[26];
            int count = 0;
            for(int i=0; i<n; i++) {
                if(d[i]==1) {
                    count++;
                    for(int j=0; j<doc[i].length(); j++) {
                        alpa[doc[i].charAt(j) - 97] = 1;
                    }
                }
            }
            int bol = 0;
            for(int i=0; i<26; i++) {
                if(alpa[i] == 0) {
                    bol = 1;
                    break;
                }
            }
            if(bol == 0) {
                result++;
            }
             
            return;
        }
        d[c] = 0;
        powerset(c+1, n, doc);
        d[c] = 1;
        powerset(c+1, n, doc);
    }
 
}

