package programmers;

public class Solution_타겟넘버 {
    
    int answer, N,T;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        T = target;
        N = numbers.length;
        dfs(numbers,0,0);
        return answer;
    }
    
    
    public void dfs(int[] nums, int n, int t){
        if(n==N){
            if(t == T) answer++;
            return;
        }
        dfs(nums, n+1, t+(-nums[n]));
        dfs(nums, n+1, t+(nums[n]));
    }
}
