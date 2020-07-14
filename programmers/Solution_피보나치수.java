package programmers;

class Solution_피보나치수 {
	  public int solution(int n) {
	      int answer = 0;
	      boolean b = true;
	      int f1 = 1;
	      int f2 = 1;
	      while(n > 2){
	          if(b==true){
	              f1 = f1%1234567+f2%1234567;
	          } else {
	              f2 = f1%1234567+f2%1234567;
	          }
	            b = !(b);
	            n--;
	      }
	      if(b==true){
	          answer = f2%1234567;
	      } else {
	          answer = f1%1234567;
	      }
	      return answer;
	  }
	}