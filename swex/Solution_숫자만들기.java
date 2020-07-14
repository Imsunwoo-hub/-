package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_숫자만들기 {
 
    public static int N, ia[], ca[], max, min; 
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new int[N];
            ca = new int[4];
            String[] s = br.readLine().split(" ");
            int idx = 0;
            for(int i =0; i<4; i++) {
                ca[i] = Integer.parseInt(s[i]);
            }
            String[] t = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                ia[i] = Integer.parseInt(t[i]);
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            perm(ia[0], 0);
            System.out.println("#"+tc+" "+(max-min));
        }
    }
     
    public static void perm(int num, int c) {
        if(c==N-1) {
            if(num > max) max = num;
            if(num < min) min = num;
            //System.out.println(max  + " " + min);
            return;
        }
         
        for(int i=0; i<4; i++) {
            if(ca[i]==0) continue;
            else {
                ca[i]--;
                if(i==0) {
                    perm(num+ia[c+1], c+1);
                }
                else if(i==1) {
                    perm(num-ia[c+1], c+1);
                }
                else if(i==2) {
                    perm(num*ia[c+1], c+1);
                }
                else if(i==3) {
                    perm(num/ia[c+1], c+1);
                }
                ca[i]++;
            }
             
        }
    }
     
     
 
}

