package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_서로소집합{
     
    public static int[] p;
    public static String[][] sa;
 
    public static void main(String[] args) throws Exception {
         
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++ ) {
             
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
             
            p = new int[n+1];
            sa = new String[m][3];
            for(int i=0; i<m; i++) {
                String[] t = br.readLine().split(" ");
                sa[i] = t;
            }
            for(int i=1; i<p.length; i++) {
                p[i] = i;
            }
             
            System.out.print("#"+tc+" ");
             
            for(int i=0; i<m; i++) {
                if(sa[i][0].equals("0")) {
                    int a = find(Integer.parseInt(sa[i][1]));
                    int b = find(Integer.parseInt(sa[i][2]));
                    if(a<b) p[b] = a;
                    else p[a] = b;
                }
                else if(sa[i][0].equals("1")) {
                    if(find(Integer.parseInt(sa[i][1])) == find(Integer.parseInt(sa[i][2]))) {
                        System.out.print("1");
                    }
                    else {
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
             
        }
 
    }
    public static int find(int a) {
        if(p[a]==a) return a;
        return p[a] = find(p[a]);
    }
 
}
