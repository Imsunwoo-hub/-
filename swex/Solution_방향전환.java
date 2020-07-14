package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_방향전환 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int[] a = new int[2];
            int[] b = new int[2];
             
            a[0] = Integer.parseInt(s[0]);
            a[1] = Integer.parseInt(s[1]);
            b[0] = Integer.parseInt(s[2]);
            b[1] = Integer.parseInt(s[3]);
             
              
             
            int result = 0;
            int xd = Math.abs(a[0]-b[0]);
            int yd = Math.abs(a[1]-b[1]);
            int t = xd > yd ? yd : xd;
            int te =  xd > yd ? xd-yd : yd-xd;
            if(te==1) {
                result = t*2+1;
            }
            else {
                if(te==0 || te%2==0 ) result = (t*2)+((te)*2);
                else {
                    result = (t*2)+((te-1)*2)+1;
                }
            }
            System.out.println("#"+tc+" "+result);
             
        }
    }
}

