package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Solution_수영장 {
     
    static int result, months[], prices[];
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<= T; tc++) {
             
            String[] s = br.readLine().split(" ");
            prices = new int[4];
            for(int i =0; i<4; i++) {
                prices[i] = Integer.parseInt(s[i]);
            }
            months = new int[12];
            ArrayList<Integer> list = new ArrayList<>();
            String[] t = br.readLine().split(" ");
            int day = 0;
            int month = 0;
            for(int i =0 ;i<12; i++) {
                months[i] = Integer.parseInt(t[i]);
                day += months[i];
                }
             
            result = prices[3];
            dfs(0,0,day);
            System.out.println("#"+tc+" "+result);
        }
    }
    public static void dfs(int i, int c, int d) {
        if(c >= result ) return;
        if(d==0) {
            if(c<result) result = c;
            return;
        }
        for(int p=0; p<3; p++) {
            if(p==2) {
                int t = 0;
                for(int j=i; j<i+3; j++) {
                    t += months[j%12];
                }
                dfs(i+3, c+prices[p], d-t);
            }
            else if (p==1) {
                dfs(i+1,c+prices[p], d-months[i%12]);
            }
            else {
                dfs(i+1, c+prices[p]*months[i%12], d-months[i%12] );
            }
        }
    }
}

