package programmers;

import java.util.*;

public class Solution_더맵게 {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>( new Comparator<Integer>() {
            
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });
        
        for(int i=0; i<scoville.length; i++){
            q.offer(scoville[i]);
        }
                        
        while(!q.isEmpty()){
            int a = q.poll();
            if(a>=K) break;
            if(q.isEmpty()) {
                answer = -1;
                break;
            }
            int b = q.poll();
            int c = a+(b*2);
            answer++;
            q.offer(c);
        }
                                                       
        return answer;
    }
}
