package programmers;

import java.util.*;

public class Solution_디스크스케줄링 {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> wq = new PriorityQueue<>(new Comparator<int[]>()         {
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[0], o2[0]);
            } 
        });
        
        for(int[] job : jobs) wq.offer(job);
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()         {
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[1], o2[1]);
            } 
        });
        
        int time = 0;
        int cnt = 0;
        while(cnt < jobs.length){
            while(!wq.isEmpty() &&  wq.peek()[0] <= time ){
                pq.offer(wq.poll());
            }
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                cnt++;
                time += curr[1];
                answer += time - curr[0];
            }
            else {
                time++;
            }
        }
        
        
        return answer/jobs.length;
    }
}