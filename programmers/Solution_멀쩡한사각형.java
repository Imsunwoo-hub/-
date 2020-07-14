package programmers;

public class Solution_멀쩡한사각형 {
	public long solution(long w,long h) {
		long answer = w*h;
        long a = w>h ? w : h ;
        long b = w>h ? h : w ;
        long c = 0;
        
        for(long i=1; i<=b; i++){
            if((a%i==0) && (b%i==0)) c = i;
        }
        
        answer = answer - (w+h-c);
        
		return answer;
	}
}