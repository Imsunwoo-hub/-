package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_옥희의OK부동산 {
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] sa = br.readLine().split(" ");
            int N = Integer.parseInt(sa[0]);
            int money = Integer.parseInt(sa[1]);
             
            String[] t = br.readLine().split(" ");
            int[] ia = new int[N];
            for(int i=0; i<N; i++) {
                ia[i] = Integer.parseInt(t[i]);
            }
             
            int count = 0;
            for(int i=0; i<N; i++) {
                int m = money;
                for(int j=i; j<N; j++) {
                    m -= ia[j];
                    if(m==0) {
                        count++;
                        break;
                    }
                    if(m<0) {
                        break;
                    }
                }
            }
            System.out.println("#"+tc+" "+count);
        }
    }
}
