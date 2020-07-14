package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main_주사위던지기2 {
     
    public static int N,M, data[];
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        data = new int[N];
         
        product(0);
    }
     
    public static void product(int count) {
        if(count==N) {
            int c = 0;
            for(int i:data) c+=i;
            if(c==M) {
            for(int i:data) System.out.print(i+" ");
            System.out.println();
            }
            return;
        }
        else {
            for(int i=1; i<=6; i++) {
                data[count] = i; 
                product(count+1);
            }
        }
    }
 
}

