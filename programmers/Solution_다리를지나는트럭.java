package programmers;

import java.util.*;
public class Solution_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<>(); 
        for(int i=0; i<truck_weights.length; i++){
            trucks.offer(truck_weights[i]);
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        
        while(true){
            answer++;
            int sum = 0;
            for(int i=0; i<list.size(); i++){
                sum += list.get(i)[0];
                list.set(i, new int[] {list.get(i)[0], list.get(i)[1]-1});
                if(list.get(i)[1] == 0){
                    sum -= list.get(i)[0];
                    list.remove(i);
                    i--;
                }
            }
            if(!trucks.isEmpty() && sum+trucks.peek() <= weight){
                int t = trucks.poll();
                list.add(new int[]{t, bridge_length});
            }
            if(trucks.isEmpty() && list.size()==0) break;
        }
        
        return answer;
    }
}