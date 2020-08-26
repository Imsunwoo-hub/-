package programmers;

class Solution_N퀸 {
    
    int answer;
    
    public int solution(int n) {
        answer = 0;
        
        int[][] map = new int[n][n];
        int[] v = new int[n];
        dfs(0,v,map,n);
        
        return answer;
    }
    
    public void dfs(int i, int[] v, int[][] map, int n){
        if(i>=n){
            answer++;
            return;
        }
        for(int j=0; j<n; j++){
            if(v[j]==0 && bol(i,j,map,n) ){
                v[j] = 1;
                map[i][j] = 1;
                dfs(i+1, v, map, n);
                v[j] = 0;
                map[i][j] = 0;
            }
        }
    }
    
    public boolean bol(int i, int j, int[][] map, int n){
        for(int a=i; a<n; a++){
            if(map[a][j]==1) return false;
        }
        for(int a=i; a>=n; a--){
            if(map[a][j]==1) return false;
        }
        for(int a=j; a>=n; a--){
            if(map[i][a]==1) return false;
        }
        for(int a=j; a<n; a++){
            if(map[i][a]==1) return false;
        }
        for(int a=0; a<n; a++ ){
            if(i-a<0 || j-a<0 ) break;
            if(map[i-a][j-a]==1) return false;
        }
        for(int a=0; a<n; a++ ){
            if(i+a>=n || j+a>=n ) break;
            if(map[i+a][j+a]==1) return false;
        }
        for(int a=0; a<n; a++ ){
            if(i-a<0 || j+a>=n ) break;
            if(map[i-a][j+a]==1) return false;
        }
        for(int a=0; a<n; a++ ){
            if(i+a>=n || j-a<0 ) break;
            if(map[i+a][j-a]==1) return false;
        }
        
        return true;
    }
}