package programmers;


public class Solution_N으로표현 {
    int answer;
    public int solution(int N, int number) {
        answer = -1;
        dfs(N,number,0,0);
        return answer;
    }
    
    public void dfs(int n, int number, int cnt, int temp){
        if(cnt > 8) return;
        if(temp == number){
            if(answer == -1) answer = cnt;
            else {
                if(answer > cnt ) answer = cnt;
            }
            return;
        }
        int x = n;
        for(int i=1; i<9-cnt; i++){
            dfs(n,number,cnt+i, temp+x);
            dfs(n,number,cnt+i, temp-x);
            dfs(n,number,cnt+i, temp*x);
            dfs(n,number,cnt+i, temp/x);
            x = x*10+n;
        }
    }
}