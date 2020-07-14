package programmers;

import java.util.*;
class Solution_경주로건설 {
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int[][][] v = new int[N][N][4];
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[3], o2[3]);
            }
        });
        
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        
        q.offer(new int[]{0,0,-1,0});
        
        while(!q.isEmpty()){
            int curr[] = q.poll();
            
            if(curr[2]==-1 || v[curr[0]][curr[1]][curr[2]]==0){
                if(curr[2]!=-1) v[curr[0]][curr[1]][curr[2]] = 1;
                
                if(curr[0]==N-1 && curr[1]==N-1){
                    answer = curr[3];
                    break;
                }
                
                for(int d = 0; d<4; d++){
                    int ni = curr[0]+di[d];
                    int nj = curr[1]+dj[d];
                    if(ni>=0 && nj >=0 &&  ni<N && nj<N && board[ni][nj]==0){
                        if( curr[2]==-1){
                            q.offer(new int[]{ni,nj,d,curr[3]+100});
                        }
                        else {
                            if(v[ni][nj][d]==0){
                                if(curr[2]==d){
                                    q.offer(new int[]{ni,nj,d,curr[3]+100});
                                }
                                else{
                                    q.offer(new int[]{ni,nj,d,curr[3]+600});
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}