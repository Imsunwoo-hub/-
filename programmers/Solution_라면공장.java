package programmers;

import java.util.*;

public class Solution_라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					
					return -Integer.compare(o1, o2);
				}
			});
        
        int idx = 0;
        while(stock < k){
            for(int i=idx; i<dates.length; i++){
                if(stock < dates[i] ) break;
                q.offer(supplies[i]);
                idx = i+1;
                
            }
            int n = q.poll();
            stock += n;
            answer++;
        }
        
        return answer;
    }
}
