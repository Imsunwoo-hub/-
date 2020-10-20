package programmers;

public class Solution_3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        
        while(true){
            if(n==0) break;
            s += n%3;
            n/=3;
        }
        for(int i=0; i<s.length(); i++){
            answer += (s.charAt(i)-'0') * (int)Math.pow(3, s.length()-1-i);
        }
        
        return answer;
    }
}
