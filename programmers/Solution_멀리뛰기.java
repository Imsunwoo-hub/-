package programmers;

class Solution_멀리뛰기 {
    
    
    public long solution(int n) {
        
        long answer = 0;
        
        if(n==1 || n==2) return n;
        else{
            long a = 1;
            long b = 2;
            for(int i=3; i<=n; i++){
                long c = (a%1234567 + b%1234567)%1234567;
                a = b;
                b = c;
                answer = c;
            }
            return answer;
        }
    }
}
