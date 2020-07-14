package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Solution_사랑의카운슬러 {
     
    public static long ia[][], a[];
    public static long result,sumx,sumy ;
    public static int N;
     
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new long[N][2];
            sumx = 0;
            sumy = 0;
            a = new long[N/2];
            List<long[]> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
     
                String[] s = br.readLine().split(" ");
                ia[i][0] = Long.parseLong(s[0]);
                ia[i][1] = Long.parseLong(s[1]);
                sumx += ia[i][0];
                sumy += ia[i][1];
            }
            result = Long.MAX_VALUE;
            comb(N,N/2);
            System.out.println("#"+tc+" "+result);
        }
    }
     
    public static void comb(int n, int r) {
        if(n<r) return;
        if(r==0) {
            long sumsx = 0;
            long sumsy = 0;
            for(int i=0; i<a.length; i++) {
                sumsx += ia[(int)a[i]][0];
                sumsy += ia[(int)a[i]][1];
            }
            long x = sumx-sumsx;
            long y = sumy-sumsy;
             
            long vx = sumsx-x;
            long vy = sumsy-y;
            result = Math.min(result, vx*vx+vy*vy);
            return;
        }
         
        a[r-1] = n-1;
        comb(n-1,r-1);
        comb(n-1,r);
         
    }
}
