package programmers;

public class Solution_이진변환반복하기 {

	 public int[] solution(String s) {
	        int[] answer = new int[2];
	        
	        int time = 0;
	        int count = 0;
	        
	        while(true){
	            if(s.equals("1")) break;
	            time++;
	            String temp = "";
	            for(int i=0; i<s.length(); i++){
	                if(s.charAt(i)=='0'){
	                    count++;
	                }
	                else {
	                    temp += s.charAt(i);
	                }
	            }
	            int n = temp.length();
	            temp = "";
	            while(true){
	                if(n==0) break;
	                temp += n%2;
	                n /= 2;
	            }
	            s = "";
	            for(int i=temp.length()-1; i>=0; i--){
	                s += temp.charAt(i);
	            }
	        }
	        answer[0] = time;
	        answer[1] = count;
	        return answer;
	    }

}
