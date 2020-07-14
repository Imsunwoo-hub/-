package programmers;

import java.util.Arrays;
class Solution_숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int start = 0;
        for(int i=0; i<A.length; i++){
            int bol = 0;
            for(int j=start; j<B.length; j++ ){
                if(A[i] < B[j]) {
                    answer ++;
                    start = j+1;
                    if(j <  B.length-1) bol = 1;
                    break;
                }
                
            }
            if(bol == 0  ) break; 
            
        }        
        
        return answer;
    }
}