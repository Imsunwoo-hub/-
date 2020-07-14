package programmers;

import java.util.*;
class Solution_저울 {
    public int solution(int[] weight) {
        int answer = 0;
        Arrays.sort(weight);
        
        answer = weight[0];
        
        for(int i=0; i<weight.length; i++){
            if(answer + 1 < weight[i]) break;
            answer += weight[i];
        }
        
    
        return answer;
    }
}