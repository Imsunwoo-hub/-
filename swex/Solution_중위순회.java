package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_중위순회 {
     
    public static String result = "";
    public static String[] sa;
    public static int N ;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        for(int tc = 1; tc <= 10; tc++)
        {   
            N = Integer.parseInt(br.readLine());
             
            sa = new String[N+1];
            result = "";
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                String[] t = s.split(" ");
                sa[Integer.parseInt(t[0])] = t[1]; 
                 
            }
            inorder(1);
            System.out.println("#"+ tc+" "+ result);
        }
    }
    public static void inorder(int i) {
        if(i<=N && sa[i] != null ) {
            inorder(i*2);
            result += sa[i];
            inorder(i*2+1);
        }
    }
}
