package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_주사위던지기1 {
     
    public static int C,N,M, data[]; 
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        data = new int[N];
         
        switch(M) {
        case 1 :
            product(0);
            break;
        case 2 :
            homogeneous(1,0);
            break;
        case 3 :
            combination(1,0);
            break;
        }
    }
     
    public static void product(int count) {
        if(count==N) {
            for(int i:data) System.out.print(i+" ");
            System.out.println();
            return;
        }
        else {
            for(int i=1; i<=6; i++) {
                data[count] = i; 
                product(count+1);
            }
        }
    }
     
    public static void homogeneous(int before, int count) {
        if(count==N) {
            for(int i:data) System.out.print(i+" ");
            System.out.println();
            return;
        }
        else {
            for(int i=before; i<=6; i++) {
                data[count] = i; 
                homogeneous(i,count+1);
            }
        }
    }
     
    public static void combination(int before, int count) {
        if(count==N) {
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    if(data[i]==data[j]) return;
                }
            }
            for(int i:data) System.out.print(i+" ");
            System.out.println();
            return;
        }
            for(int i=1; i<=6; i++) {
                data[count] = i; 
                combination(i,count+1);
            }
        }
 
}
