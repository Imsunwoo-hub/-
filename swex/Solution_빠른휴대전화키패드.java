package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_빠른휴대전화키패드 {
 
    public static void main(String[] args) throws Exception {
         
 
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<= T; tc++) {
            String[] t = br.readLine().split(" ");
            String s = t[0];
            String[] pad = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
            String[] ws = br.readLine().split(" ");
             
            int result = 0;
             
            for(int i=0; i<ws.length; i++) {
                String w = ws[i];
                if(w.length() != s.length()) continue;
                int bol = 0;
                for(int j=0; j<s.length(); j++) {
                    int idx = s.charAt(j) - '0';
                    String temp = pad[idx];
                    if(!temp.contains(w.charAt(j)+"")) {
                        bol = 1;
                        break;
                    }
                }
                if(bol==0) result++;
            }
             
            System.out.println("#"+tc+" " +result);
        }
 
    }
 
}

