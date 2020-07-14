package programmers;

import java.util.Arrays;

class Solution_쿠키구입 {
    public int solution(int[] cookie) {
        int answer = 0;
        
        
        for(int i =0; i<cookie.length-1; i++){
            int l = i;
            int r = i+1;
            int sum1 = cookie[l];
            int sum2 = cookie[r];
            
            if(sum1== sum2 && sum1> answer) answer = sum1;
            
            while(true){
                 
            if (0 < l && sum1 <= sum2) {
                l--;
                sum1 += cookie[l];
            }
            else if (r < cookie.length-1 && sum1 >= sum2) {
                r++;
                sum2 += cookie[r];
            }
            else {
                break;
            }
            if (sum1 == sum2 && answer<sum1) answer = sum1;
             
         }
            
            
            
        }
        
        

        return answer;
    }
}