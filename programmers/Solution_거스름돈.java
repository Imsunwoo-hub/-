package programmers;

public class Solution_거스름돈 {
    public int solution(int n, int[] money) {
        
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=money[0]; i<=n; i+=money[0]) dp[i] = 1;
        
        
        for(int i=1; i<money.length; i++){
            for(int j=0; j<=n; j++){
                if(j>=money[i]) dp[j] += dp[j-money[i]]%mod;
            }
        }
        
        return dp[n];
    }
}
