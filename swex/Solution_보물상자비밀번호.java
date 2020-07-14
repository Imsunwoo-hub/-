package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
public class Solution_보물상자비밀번호 {
 
    public static void main(String[] args) throws Exception {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            char[] ca = br.readLine().toCharArray();
            int[] ia = {10,11,12,13,14,15};
            List<Integer> list = new ArrayList<>();
            int w = N/4;
            int idx = 0;
             
            while(idx<w) {
                 
                for(int i=N-idx; i<2*N-idx; i+=N/4) {
                    String temp = "";
                    for(int j=i; j<i+N/4; j++) {
                        temp += ca[j%N];
                    }
                    //System.out.println(temp);
                    /*int t = 0;
                    for(int k=temp.length()-1; k>=0; k--) {
                        int a = temp.charAt(k);
                        if(a>='0' && a<='9') a = a-'0';
                        else if(a < 0 || a > 9) a = ia[a-65];
                         
                        t += a * Math.pow(16, k);
                    }*/
                    //System.out.println(t);
                    int a = Integer.parseInt(temp,16);
                    //System.out.println(a);
                    if (!list.contains(a))list.add(a);
                }
                idx++;
            }
             
            Collections.sort(list);
            System.out.println("#"+tc+" " + list.get(list.size()-K));
        }
         
    }
}

