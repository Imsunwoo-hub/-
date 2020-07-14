package programmers;

public class Solution_카카오프렌즈컬러링북 {
    
    public int[] di = {-1,1,0,0};
    public int[] dj = {0,0,-1,1};
    public int count, v[][];
    
  public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      v = new int[m][n];
      for(int i=0; i<m; i++ ){
          for(int j=0; j<n; j++){
              if(picture[i][j]!=0 &&  v[i][j]==0){
                  v[i][j] = 1;
                  numberOfArea++;
                  count = 1;
                  dfs(picture,i,j);
                  if(count > maxSizeOfOneArea ) maxSizeOfOneArea = count;
              }
          }
      }
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
    
  public void dfs(int[][] picture,  int i, int j){
      
      for(int d=0; d<di.length; d++){
          int ni = i+di[d];
          int nj = j+dj[d];
          if(ni>=0 && ni<v.length && nj>=0 && nj<v[0].length && v[ni][nj]==0 && picture[ni][nj] !=0 && picture[ni][nj] == picture[i][j]){
              v[ni][nj] = 1;
              count++;
              dfs(picture,ni,nj);
          }
      }
  }  
}
