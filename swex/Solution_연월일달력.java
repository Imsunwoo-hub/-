package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_연월일달력 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cal = {0,31,28,31,30,31,30,31,31,30,31,30,31};
         
        int T = Integer.parseInt(br.readLine());
         
     
        for(int tc=1; tc<=T; tc++) {
             
            String s = br.readLine();
             
            String year = "";
            String month = "";
            String day = "";
            String result = "";
             
            for(int i=0; i<s.length(); i++) {
                if(i<4) year += s.charAt(i);
                else if(i>=4 && i<6) month += s.charAt(i);
                else day += s.charAt(i);
            }
             
            if(Integer.parseInt(month)>0 && Integer.parseInt(month) < 13 ) {
                result += year+"/"+month;
                if(Integer.parseInt(day)>0 && Integer.parseInt(day) <= cal[Integer.parseInt(month)]) {
                    result += "/"+day;
                }
                else result= "-1";
            }
            else {
                result = "-1";
            }
             
            System.out.println("#"+tc+" "+result);
        }
    }
 
}

