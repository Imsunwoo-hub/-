package programmers;

import java.util.*;
class Solution_최고의집합 {
    
  
  public int[] solution(int n, int s) {
     int[] answer = new int[n];
     int[] ia = new int[n];
     int avg = s/n;
      if(avg==0) return new int[] {-1};
      int sum =  0;
     for(int i=0; i<n; i++){
        ia[i] = avg;
        sum += ia[i];
     }
      int c = s-sum;
      int idx = n-1;
      while(c>0){
          ia[idx--]++;
          c--;
          if(idx<0) idx = n-1;
      }
     
      return ia;
   }
}
