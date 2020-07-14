package programmers;

class Solution_네트워크 {
    
    int N, v[][];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        N = computers.length;
        v = new int[N][N];
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(computers[i][j]==1 && v[i][j]==0 && v[j][i]==0){
                    answer ++;
                    v[i][j] = 1;
                    v[j][i] = 1;
                    dfs(j,computers);
                }
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int i,int[][] computers){
        for(int j=0; j<N; j++){
            if(computers[i][j]==1 && v[i][j]==0 && v[j][i]==0){
                v[i][j] = 1;
                v[j][i] = 1;
                dfs(j,computers);
            }
        }
    }
}