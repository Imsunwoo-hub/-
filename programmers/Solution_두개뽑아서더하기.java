package programmers;

import java.util.*;

public class Solution_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
       
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i==j) continue;
                set.add(numbers[i]+numbers[j]);
            }
        }
        int idx=0;
        int[] answer = new int[set.size()];
        for(int s:set) answer[idx++] = s;
        Arrays.sort(answer);
        return answer;
    }
}
