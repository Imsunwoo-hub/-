package programmers;

import java.util.*;
class Solution_n진수게임 {
  public static String solution(int n, int t, int m, int p) {
        String answer = "";
        char[] ca = new char[t * m];
        ca[0] = '0';
        char[] ia = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int num = 1;
        int idx = 1;
        while(idx < ca.length) {
            int end = num;
            Stack<Character> stack = new Stack<>();
            while(end > 0){
                int mod = end % n;
                stack.push(ia[mod]);
                end /= n;
            }
            while(!stack.isEmpty()){
                if(idx > ca.length - 1) break;
                ca[idx++] = stack.pop();    
            }
            num++;
        }
        for(int i=0; i<ca.length; i++){
            if(m==p){
                if((i+1)%m == 0) answer += ca[i];
            }
            else{
                if((i+1)%m == p) answer += ca[i];
            }
            
        }
        return answer;
    }
     
}
