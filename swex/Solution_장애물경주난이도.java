package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_장애물경주난이도 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int up = 0;
            int down = 0;
            for(int i=1; i<N; i++) {
                if(Integer.parseInt(s[i-1])>Integer.parseInt(s[i])) {
                    if(Integer.parseInt(s[i-1])-Integer.parseInt(s[i])>down){
                        down = Integer.parseInt(s[i-1])-Integer.parseInt(s[i]);
                    }
                     
                } else if(Integer.parseInt(s[i-1])<Integer.parseInt(s[i])) {
                    if(Integer.parseInt(s[i])-Integer.parseInt(s[i-1])>up) {
                        up = Integer.parseInt(s[i])-Integer.parseInt(s[i-1]);
                    }
                }
            }
            System.out.println("#"+tc+" "+up+" "+down);
        }
    }
}

