package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_사칙연산유효성검사 {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc=1; tc<=10; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            int result = 1;
             
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                if(t[1].equals("+") || t[1].equals("-") || t[1].equals("*") || t[1].equals("/") )
                {
                    if(t.length<3) {
                        result = 0;
                     
                    }
                }
                else {
                    if(t.length>2) {
                        result = 0;
                    }
                }
            }
             
            System.out.println("#"+tc+" " + result);
             
        }
    }
}
