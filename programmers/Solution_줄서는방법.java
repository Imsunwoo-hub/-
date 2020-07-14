package programmers;

import java.util.*;

class Solution_줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long f = 1;
        for(int i=1; i<=n; i++){
            f *= i;
            list.add(i);
        }
        k--;
        int idx = 0;
        while(n>0){
            f /= n;
            n--;
            answer[idx++] = list.get((int)(k/f));
            list.remove((int)(k/f));
            k %= f;
        }
        
        return answer;
    }
}
