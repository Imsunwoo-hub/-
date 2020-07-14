package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Solution_정식이의은행업무 {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            char[] two = br.readLine().toCharArray();
            char[] three = br.readLine().toCharArray();
             
            ArrayList<Long> list = new ArrayList<>();
     
            long tw = 0; 
            for(int i=0; i<two.length; i++ ) {
                tw += (two[i] -'0') * (int)Math.pow(2, two.length-1-i);
                 
            }
            for(int i=0; i<two.length; i++ ) {
                long t = (long) Math.pow(2, two.length-1-i);
                if(two[i]=='1') {
                    t = tw-t; 
                }else {
                    t = tw+t;
                }
                list.add(t);
            }
            long th = 0;
            for(int i=0; i<three.length; i++ ) {
                th += (three[i]-'0') * Math.pow(3, three.length-1-i);
            }
            long result= 0;
             
            for(int i=0; i<three.length; i++ ) {
                long t =(long)Math.pow(3, three.length-1-i);
                long t1 = 0;
                long t2 = 0;
                if(three[i]=='0') {
                    t1 = th+t;
                    t2 = th+2*t;
                }
                else if(three[i]=='1') {
                    t1 = th-t;
                    t2 = th+t;
                }
                else {
                    t1 = th-t;
                    t2 = th-2*t;
                }
                 
                if(list.contains(t1)) {
                    result = t1;
                    break;
                }
                else if(list.contains(t2)) {
                    result = t2;
                    break;
                }
            }
             
            System.out.println("#"+tc+" "+result);
        }
    }
 
}

