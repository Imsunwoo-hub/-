package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_하나로 {
     
    public static int N;
    public static long w[],a[][];
    public static long INF = Long.MAX_VALUE;
    public static double E;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            long[] x = new long[N];
            long[] y = new long[N];
            a = new long[N][N];
            String[] xs = br.readLine().split(" ");
            String[] ys = br.readLine().split(" ");
             
            for(int i=0; i<N; i++) {
                x[i] = Long.parseLong(xs[i]);
                y[i] = Long.parseLong(ys[i]);
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) a[i][j] = 0;
                    else {
                        a[i][j] = ((x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]));
                        a[j][i] = ((x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]));
                    }
                }
            }
             
            E = Double.parseDouble(br.readLine());
            w = new long[N];
            long result = prim();
             
            result = Math.round(result*E);
            System.out.println("#"+tc+" "+result);
        }
    }
    public static long prim() {
         
        long sum = 0;
        Arrays.fill(w, -1);
        w[0] = 0;
        for(int k=1; k<N; k++) {
            long minW = INF;
            int minV = 0;
            for(int i=0; i<N; i++) {
                if(w[i]<0) continue;
                for(int j=0; j<N; j++) {
                    if(w[j]>=0) continue;
                    if(a[i][j] < minW) {
                        minW = a[i][j];
                        minV = j;
                    }
                }
            }
            w[minV] = minW;
            sum += minW;
        }
        return sum;
    }
     
}
