package programmers;

import java.util.*;
class Solution_하노이의탑 {
    
    ArrayList<int[]> list;
    
    public int[][] solution(int n) {
        
        list = new ArrayList<>();
        
        solve(n, 1, 3 , 2);
        
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }
    
    public void solve(int n, int start, int end, int sub){
        if(n==1){
            list.add(new int[] {start, end});
            return;
        }
        solve(n-1, start, sub, end);
        list.add(new int[] {start, end});
        solve(n-1, sub, end, start);
    }
}
