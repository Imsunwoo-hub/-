package programmers;

class Solution_자물쇠와열쇠 {
    
    int N,M;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        N = key.length;
        M = lock.length;
        
        int[][] map = new int[(N-1)*2+M][(N-1)*2+M];
        
        for(int i=N-1; i<N-1+M; i++){
            for(int j=N-1; j<N-1+M; j++){
                 map[i][j] = lock[i-(N-1)][j-(N-1)];
             }
         }
        
        for(int i=0; i<4; i++){
            rotate(key);
            
            for(int a=0; a<=map.length-key.length; a++){
                for(int b=0; b<=map.length-key.length; b++){
                    if(solve(a,b,key, map)) {
                        answer = true;
                        break;
                    }
                }
            }
            if(answer==true) break;
        }
      
        return answer;
    }
    
    public void rotate(int[][] key) {
        int[][] temp = new int[key.length][key.length];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                temp[i][j] = key[key.length-1-j][i];
            }
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                key[i][j] = temp[i][j];
            }
        }   
    }
    
    
    public boolean solve(int a, int b, int[][] key, int [][] map){
        
        int [][] temp = new int[map.length][map.length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                temp[i][j] = map[i][j];
            }
        }
        
        for(int i=a; i<a+key.length; i++){
            for(int j=b; j<b+key.length; j++){
                if(key[i-a][j-b]==1 && temp[i][j]==1) return false;
                if(key[i-a][j-b]==1 && temp[i][j]==0) temp[i][j] = 1;
            }
        }
        
        for(int i=N-1; i<N-1+M; i++){
            for(int j=N-1; j<N-1+M; j++){
                if(temp[i][j]==0) return false;
            }
        }
        return true;
    } 
    
}
