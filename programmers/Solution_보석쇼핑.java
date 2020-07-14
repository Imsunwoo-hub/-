package programmers;

import java.util.*;

class Solution_보석쇼핑 {
    public int[] solution(String[] gems) {
        
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String>    q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int size = set.size();
        
        int start = 0;
        int sp = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++) {
        	
        	if(!map.containsKey(gems[i])) map.put(gems[i], 1);
        	else map.put(gems[i], map.get(gems[i]) + 1);
        	q.add(gems[i]);
        
        	while(true) {
        		String temp = q.peek();
        		if(map.get(temp) > 1) {
        			map.put(temp, map.get(temp) - 1);
        			q.poll();
        			sp++;
        		}
        		else {
        			break;
        		}
        	}
        	if(map.size() == set.size() && length > q.size()) {
        		length = q.size();
        		start = sp;
        	}
        }
        return new int[]{start + 1, start + length};  
    }
}
