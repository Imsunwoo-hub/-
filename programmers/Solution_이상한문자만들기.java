package programmers;

public class Solution_이상한문자만들기 {
	  public String solution(String s) {
	      String answer = "";
	      int count = 0;
	      for (int i =0; i<s.length(); i++){
	          count++;
	          if(s.charAt(i)==' '){
	              answer += " ";
	              count = 0;
	          }
	          else{
	              if(count%2==1) {
	                   if(s.charAt(i)>96 && s.charAt(i)<123) answer += (char)(s.charAt(i)-32);
	                    else answer += (char)(s.charAt(i));

	              }
	              else{
	                  if(s.charAt(i)>64 && s.charAt(i)<91) answer += (char)(s.charAt(i)+32);
	                  else answer += (char)(s.charAt(i));

	              }
	          }
	      }
	      
	      return answer;
	  } 
	}
