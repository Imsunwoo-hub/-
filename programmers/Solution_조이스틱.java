package programmers;

import java.util.*;
public class Solution_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int[] ia = new int[name.length()];
        for(int i=0; i<ia.length; i++){
            int a = Math.abs(0-(name.charAt(i)-65));
            int b = Math.abs(26-(name.charAt(i)-65));
            ia[i] =  Math.min(a,b);
        }
        //System.out.println(Arrays.toString(ia));
        int idx = 0;
        
        while(true){
            answer+= ia[idx];
            ia[idx] = 0;
            
            int bol = 0;
            for(int j=0; j<ia.length; j++){
                if(ia[j] != 0){
                    bol = 1;
                    break;
                }
            }
            if(bol==0) break;
            int l = idx;
            //if(l < 0) l = ia.length -1 ;
            int r = idx;//(idx+1) % ia.length;
            int lc= 0;
            int rc = 0;
            while(ia[l] <= 0){
                lc++;
                l--;
                if(l < 0) l = ia.length-1;
            }
            while(ia[r] <= 0){
                rc++;
                r = (r+1)%ia.length;
            }
            if(lc < rc){
                idx = l;
                answer += lc;
            } else {
                idx = r;
                answer += rc;
            }
            
        }
        
        return answer;
    }
}
