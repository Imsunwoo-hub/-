package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_색종이만들기 {
     
    public static int b_c, w_c;
    public static String[][] sa;
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
         
        sa = new String[N][];
        for(int i=0; i<N; i++ ) {
            String s = br.readLine();
            sa[i] = s.split(" ");
        }
     
        solution(0,0,N);
        System.out.println(w_c);
        System.out.println(b_c);
    }   
     
    public static void solution(int x, int y, int n) {
         
        int sum = 0;
        for(int i=x; i<x+n; i++ ) {
            for(int j=y; j<y+n; j++) {
                sum += Integer.parseInt(sa[i][j]);
            }
        }
        if(sum==0) w_c++;
        else if(sum==n*n) b_c++; 
         
        else {
            solution(x,y,n/2);
            solution(x,y+n/2,n/2);
            solution(x+n/2,y,n/2);
            solution(x+n/2,y+n/2,n/2);
        }
         
    }
}

