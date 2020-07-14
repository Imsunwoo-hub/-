package programmers;

class Solution_방문길이 {
    public int solution(String dirs) {
        
        int answer = 0;
        
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        
        int[][] map  = new int [11][11];
        int[][] gp = new int[121][121];
        
        int i = 5;
        int j = 5;
        
        for(int d=0; d < dirs.length(); d++){
            char c = dirs.charAt(d);
            if(c=='U'){
                int ni = i+di[0];
                int nj = j+dj[0];
                if(ni>=0 && nj >=0 && ni<11 && nj<11){
                    int from = i*10+(j+i);
                    int to = ni*10 + (nj+ni);
                    if(gp[from][to]==0){
                        gp[from][to] = 1;
                        gp[to][from] = 1;
                        answer++;
                    }
                    i = ni;
                    j = nj ; 
                }
            }
            if(c=='D'){
                int ni = i+di[1];
                int nj = j+dj[1];
                if(ni>=0 && nj >=0 && ni<11 && nj<11){
                    int from = i*10+(j+i);
                    int to = ni*10 + (nj+ni);
                    if(gp[from][to]==0){
                        gp[from][to] = 1;
                        gp[to][from] = 1;
                        answer++;
                    }
                    i = ni;
                    j = nj ; 
                }
                
            }
            if(c=='R'){
                int ni = i+di[3];
                int nj = j+dj[3];
                if(ni>=0 && nj >=0 && ni<11 && nj<11){
                    int from = i*10+(j+i);
                    int to = ni*10 + (nj+ni);
                    if(gp[from][to]==0){
                        gp[from][to] = 1;
                        gp[to][from] = 1;
                        answer++;
                    }
                    i = ni;
                    j = nj ; 
                }
            }
            if(c=='L'){
                int ni = i+di[2];
                int nj = j+dj[2];
                if(ni>=0 && nj >=0 && ni<11 && nj<11){
                    int from = i*10+(j+i);
                    int to = ni*10 + (nj+ni);
                    if(gp[from][to]==0){
                        gp[from][to] = 1;
                        gp[to][from] = 1;
                        answer++;
                    }
                    i = ni;
                    j = nj ; 
                }
            }
        }
    
        return answer;
    }
}