package programmers;


public class Solution_보행자천국{
    static int MOD = 20170805;

    public static int solution(int m, int n, int[][] cityMap) {
        
        int[][][] dp = new int[m+1][n+1][2];
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;
        
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		if(cityMap[i-1][j-1]==0) {
        			dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
        			dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
        		}
        		else if(cityMap[i-1][j-1]==1) {
        			dp[i][j][0] = 0;
        			dp[i][j][1] = 0;
        		}
        		else {
        			dp[i][j][0] = dp[i-1][j][0];
        			dp[i][j][1] = dp[i][j-1][1];
        		}
        	}
        }
        
        return dp[m][n][0];
    }
    
  

	public static void main(String[] args) {
		
		System.out.println(solution(3, 3, new int[3][3]));

	}

}
