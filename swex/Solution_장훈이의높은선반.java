package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_장훈이의높은선반 {
     
    public static int top, min,N, v[], ia[];
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            top = Integer.parseInt(s[1]);
            ia = new int[N];
            v = new int[N];
            min = Integer.MAX_VALUE;
            String[] sa = br.readLine().split(" ");
             
            for(int i=0; i<N; i++) {
                ia[i] = Integer.parseInt(sa[i]);
            }
            powerset(0);
            System.out.println("#"+tc+" "+min); 
        }
    }
     
    public static void powerset(int count) {
        if(count==N) {
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(v[i]==1) 
                {
                    sum += ia[i];
                }
            }
            if(sum >= top) {
                if(min>sum-top )
                    min = sum-top;
            }
            return;
        }
        v[count]=0;
        powerset(count+1);
        v[count]=1;
        powerset(count+1);
         
    }
}

