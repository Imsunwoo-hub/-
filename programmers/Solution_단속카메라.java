package programmers;

import java.util.*;

class Solution_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				
				return Integer.compare(arg0[0], arg1[0]);
			}
		});
       // for(int[] i :routes ) System.out.println(Arrays.toString(i));
        
        
        int max = routes[0][1];

        for(int i=1; i<routes.length; i++){
            if(routes[i][0] > max){
                answer++;
                max = routes[i][1];
            }
            else{
              if(routes[i][1] < max ){
                  max = routes[i][1];
              }   
            }
        }
        
        return answer;
    }
}