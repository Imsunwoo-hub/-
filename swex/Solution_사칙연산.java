package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_사칙연산 {
     
    public static int N;
    public static String[][] sa;
    public static int[] ia;
    public static double result;
 
    public static void main(String[] args) throws Exception {
         
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc=1; tc<=10; tc++) {
             
            N = Integer.parseInt(br.readLine());
            sa = new String[N+1][4];
            int [] ia = new int[N+1];
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                if(t[1].equals("+") || t[1].equals("-") || t[1].equals("*") || t[1].equals("/")) {
                    sa[Integer.parseInt(t[0])][0] = t[0];
                    sa[Integer.parseInt(t[0])][1] = t[1];
                    sa[Integer.parseInt(t[0])][2] = t[2];
                    sa[Integer.parseInt(t[0])][3] = t[3];
                }
                else {
                    ia[Integer.parseInt(t[0])] = Integer.parseInt(t[1]);
                }
            }
            double result = 0.0;
             
            for(int i=N-1; i>0; i--) {
                String s = sa[i][1];
                if(s==null) continue;
                if(s.equals("+")) {
                    ia[i] = ia[Integer.parseInt(sa[i][2])] + ia[Integer.parseInt(sa[i][3])]; 
                }
                else if(s.equals("-")) {
                    ia[i] = ia[Integer.parseInt(sa[i][2])] - ia[Integer.parseInt(sa[i][3])]; 
                }
                else if(s.equals("*")) {
                    ia[i] = ia[Integer.parseInt(sa[i][2])] * ia[Integer.parseInt(sa[i][3])];
                }
                else if(s.equals("/")) {
                    if(ia[Integer.parseInt(sa[i][2])]==0) {
                        ia[i] = 0;
                    }
                    else {
                        ia[i] = ia[Integer.parseInt(sa[i][2])] / ia[Integer.parseInt(sa[i][3])]; 
                    }
                }
            }
            result = ia[1];
            System.out.println("#"+tc+" "+(int)result);
        }
    }
}
