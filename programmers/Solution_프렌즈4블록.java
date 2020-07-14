package programmers;

class Solution_프렌즈4블록 {
    
	  int answer;
	    
	  public int solution(int m, int n, String[] board) {
	      answer = 0;
	      char[][] map = new char[m][n];
	      for(int i=0; i<m; i++){
	          for(int j=0; j<n; j++){
	                map[i][j] = board[i].charAt(j); 
	          }
	      }
	      int[][] v = new int[m][n]; 
	      while(true){
	          vclear(v,m,n);
	          int bol = map_solve(v,map,m,n);
	          if(bol==0) break;
	          move(v,map,m,n);
	      }
	      return answer;
	  }
	    
	 public void move(int[][] v, char[][] map, int m, int n){
	     for(int i=0; i<m; i++){
	         for(int j=0; j<n; j++ ){
	             if(v[i][j]==1) map[i][j] = 'x';
	         }
	     }
	     for(int j=0; j<n; j++){
	         for(int i=m-1; i>=0; i--){
	             if(map[i][j]=='x'){
	                 for(int k=i; k>=0; k--){
	                     if(map[k][j] != 'x'){
	                         map[i][j] = map[k][j];
	                         map[k][j] = 'x';
	                         break;
	                     }
	                 }
	             }
	         }
	     }
	 }   
	    
	    public void vclear(int[][] v,int m, int n){
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                v[i][j] = 0;
	            }  
	        }
	    }
	    
	    public int map_solve(int[][] v, char[][] map, int m, int n){
	        int bol = 0;
	        for(int i=0; i<m-1; i++){
	              for(int j=0; j<n-1; j++){
	                  if(map[i][j] != 'x' && map[i][j] == map[i+1][j] && map[i+1][j] == map[i+1][j+1] && map[i+1][j+1] == map[i][j+1] ){
	                      bol=1;
	                      if(v[i][j] == 0) {
	                          answer++;
	                          v[i][j] = 1;
	                      }
	                      if( v[i+1][j] == 0) {
	                          answer++;
	                          v[i+1][j] = 1;
	                      }
	                      if(v[i+1][j+1] == 0) {
	                          answer++;
	                          v[i+1][j+1] = 1;
	                      }
	                      if(v[i][j+1] == 0) {
	                          answer++;
	                          v[i][j+1] = 1;
	                      }
	                  }
	              }
	          }
	        return bol;
	    }
	}