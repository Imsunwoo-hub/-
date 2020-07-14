package programmers;

import java.util.*;
class Solution_징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<stones.length; i++){
            if(min > stones[i]) min = stones[i];
            if(max < stones[i]) max = stones[i];
        }
        int[] temp = new int[stones.length];
        while(min <= max){
            int mid = (min+max)/2;
            int cnt = 0;
            int bol = 0;
            for(int i=0; i<stones.length; i++){
                temp[i] = stones[i] - mid;
                if(temp[i] <= 0) cnt++;
                else cnt = 0;
                if(cnt >= k){
                    bol = 1;
                    break;
                }
            }
            if(bol == 1){
                max = mid -1;
               
            }else {
                min = mid+1;
            }     
        }
         
        answer = min; 
        return answer;
    }
}