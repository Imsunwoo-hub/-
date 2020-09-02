package programmers;

import java.util.*;

public class Solution_징검다리 {
	
	public static void main(String[] args) {
		
	}
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l = 0;
        int r = distance;
        
        while(l<=r){
            int mid = (l+r)/2;
            int cnt = 0;
            int before = 0;
            
            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-before < mid){
                    cnt++;
                }
                else before = rocks[i];
            }
            
            if(distance-before < mid) cnt++;
            
            if(cnt>n){
               r = mid-1; 
            }
            else {
                answer = mid;
                l = mid+1;
            }
        }
        
        return answer;
    }
}
