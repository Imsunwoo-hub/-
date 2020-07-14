package programmers;

class Solution_순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = Integer.MAX_VALUE/2;
        if(n==1) return 1;
        int[][] ia = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) ia[i][j] = 0;
                else ia[i][j] = INF;
            }
        }
        
        for(int i=0; i<results.length; i++){
            ia[results[i][0]][results[i][1]] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(ia[j][k] > ia[j][i] + ia[i][k]){
                        ia[j][k] = ia[j][i] + ia[i][k] ;
                    }
                }
            }
        }
        
        int[] v = new int[n+1]; 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(ia[i][j]==INF && ia[j][i]==INF){
                    v[i] = 1;
                    break;
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(v[i]==0) answer++;
        }
        
        return answer;
    }
}