package programmers;

import java.util.*;

class Solution_호텔방배정 {
    
    Map<Long, Long> m = new HashMap<>(); 
    
    public long[] solution(long k, long[] room_number) {
        int N = room_number.length;
       
        long[] answer = new long[N];
        
        for(int i=0; i<room_number.length; i++){
            
            answer[i] = find(room_number[i]);
            
        }
        
        return answer;
    }
    
    public long find(long r){
        if(!m.containsKey(r)){
            m.put(r, r+1);
            return r;
        }
        
        m.put(r, find(m.get(r))); 
        return m.get(r);
    }
}
