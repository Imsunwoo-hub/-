package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main_종교 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
         
        int[] p = new int[N+1];
        for(int i=1; i<p.length; i++) {
            p[i] = i;
        }
        int[][] ia = new int[M][2];
        for(int i=0; i<M; i++) {
            String[] t = br.readLine().split(" ");
            ia[i][0] = Integer.parseInt(t[0]);
            ia[i][1] = Integer.parseInt(t[1]);
            union(p, ia[i][0], ia[i][1]);
        }
        //int[] count = new int[p.length];
        int result = 0;
         
        for(int i=1;  i<p.length; i++) {
            if(p[i]==i) result++;
        }
        /*for(int i=1;  i<p.length; i++) {
            if(count[i]!=0) {
                result ++;
            }
        }*/
        System.out.println(result);
 
    }
     
    public static void union(int[] p, int a, int b) {
        int i= findset(p, a);
        int j = findset(p, b);
        if(i < j) p[j] = i;
        else p[i] = j;
         
    }
    public static int findset(int[] p, int a) {
        if(p[a]==a) return a;
        return p[a] = findset(p, p[a]);
    }
 
}

