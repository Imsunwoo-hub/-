package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_최적경로 {
     
    public static int[][] home, company ,customer;
    public static int min,N;
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            String[] sa = new String[N*2+4];
             
            sa = br.readLine().split(" "); 
            home = new int[1][2];
            company = new int[1][2];
            customer = new int[N][2];
            company[0][0] = Integer.parseInt(sa[0]);
            company[0][1] = Integer.parseInt(sa[1]);
            home[0][0] = Integer.parseInt(sa[2]);
            home[0][1] = Integer.parseInt(sa[3]);
            int idx = 0;
            for(int i=5; i<sa.length; i+=2) {
                customer[idx][0] = Integer.parseInt(sa[i-1]);
                customer[idx][1] = Integer.parseInt(sa[i]);
                idx++;
            }
            min = Integer.MAX_VALUE;
            perm(0);
            System.out.println("#"+tc+" "+min);
             
        }
    }
     
     
    public static void swap(int i, int j) {
        if(i==j) return;
        int[] temp = customer[i];
        customer[i] = customer[j];
        customer[j] = temp;
    }
 
    public static void perm(int count) {
         
        if(count==N) {
            int m = 0;
            m = Math.abs(company[0][0] - customer[0][0]) + Math.abs(company[0][1] - customer[0][1]);
            if(m>min) return;
            for(int i=1; i<customer.length; i++) {
                m += Math.abs(customer[i-1][0] - customer[i][0]) + Math.abs(customer[i-1][1] - customer[i][1]);
                if(m>min) return;
            }
            m += Math.abs(customer[customer.length-1][0] - home[0][0]) + Math.abs(customer[customer.length-1][1] - home[0][1]);  
            if(m<min) min = m;
            return;
        }
            for(int i=count; i<N; i++) {
                swap(i,count);
                perm(count+1);
                swap(i,count); 
                }
            }
}
