package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_홀수중간값피라미드2 {
     
    static int[] ia, bol;
    static int mid, N;
 
    public static void main(String[] args) throws Exception {
         
     
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
             
            ia = new int[2*N];
            String[] s = br.readLine().split(" ");
            for(int i=1; i<2*N; i++) {
                ia[i] = Integer.parseInt(s[i-1]);
            }
            int start = 1;
            int end = 2*N-1;
            solve(start, end);
            System.out.println("#"+tc+" "+ mid );
        }
         
         
         
    }
    public static void solve(int s, int e) {
        int m = (s+e)/2;
        if(m==e || m==s) {
            mid = m;
            return ;
        }
        boolean b = find(m);
        if(b) solve(m, e);
        else solve(s,m);
    }
     
    public static boolean find(int n) {
         
        for(int i=N+1; i<2*N; i++) {
            if(ia[i-1] >= n && ia[i] >= n ) return true;
            else if (ia[i-1] < n && ia[i] < n ) return false;
            if(ia[N-(i-N)] >= n && ia[N-(i-N) + 1] >= n ) return true;
            else if(ia[N-(i-N)] <n && ia[N-(i-N) + 1]< n ) return false;
        }
         
        if(ia[2*N-1] >= n) return true;
        else return false;
         
    }
 
}

