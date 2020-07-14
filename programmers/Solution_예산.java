package programmers;

import java.util.*;
class Solution_예산 {
   
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = 0;
        for(int i=0; i<budgets.length; i++){
             if(budgets[i] > right ) right = budgets[i];
        }
        
        while(left <= right ){
            int mid = (left+right)/2;
            long sum = 0;
            for(int i=0; i<budgets.length; i++){
                if(budgets[i] <= mid ) sum += budgets[i];
                else sum += mid;
            }
            
            if(sum < M) {
                if(left > answer) answer = mid;
                left = mid+1;
            }
            else if(sum==M) return mid;
            else {
                right = mid-1;
            }
        }
        return answer;
    }
}
