package programmers;

class Solution_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n][m];
        
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        map[n-1][m-1] = 1;
        
        answer = solve(0,0,map,n,m);
        
        return answer;
    }
    
    public int solve(int i, int j, int[][] map , int n ,int m ){
        if(i> n-1 || j> m-1 || map[i][j]==-1) return 0;
        if( map[i][j] > 0) return map[i][j];
        return map[i][j] = (solve(i+1, j, map, n,m) + solve(i, j+1, map,n,m) ) % 1000000007;
    }
    
}