package programmers;

import java.util.*;
class Solution_블록이동하기 {
    
    int answer;
    
    public int solution(int[][] board) {
        answer = 0;
        int N = board.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[4], o2[4]);
            }
        });
        q.offer(new int[]{0,0,0,1,0,0});
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        ArrayList<int[]> vlist = new ArrayList<>(); 
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if((curr[0]==board.length-1 && curr[1]==board.length-1) || (curr[2]==board.length-1 && curr[3]==board.length-1) ){
                answer = curr[4];
                break;
            }
            if(contains(vlist, curr)){
                vlist.add(new int[] {curr[0], curr[1], curr[2], curr[3]});
               // ㅡ
            if(curr[5]==0){
                for(int d =0; d<4; d++){
                    int li = curr[0]+di[d];
                    int lj = curr[1]+dj[d];
                    int ri = curr[2]+di[d];
                    int rj = curr[3]+dj[d];
                    if(li>=0 && lj>=0 && ri>=0 && rj>=0 && li<N && lj<N && ri<N && rj<N && board[li][lj]==0 && board[ri][rj]==0){
                        if(contains(vlist, new int[] {li,lj,ri,rj})) q.offer(new int[] {li,lj,ri,rj,curr[4]+1, 0});
                    }
                }
                // 회전
                //1 
                if(curr[0] > 0 && board[curr[2]-1][curr[3]] == 0 && board[curr[2]-1][curr[3]-1]==0){
                   if(contains(vlist, new int[] { curr[2]-1, curr[3]-1, curr[0],curr[1], curr[4]+1, 1})) 
                       q.offer(new int[] { curr[2]-1, curr[3]-1, curr[0],curr[1], curr[4]+1, 1});
                }
                if(curr[0] > 0 &&  board[curr[0]-1][curr[1]] == 0 && board[curr[0]-1][curr[1]+1] == 0){
                    if(contains(vlist, new int[] {curr[0]-1,curr[1]+1, curr[2], curr[3], curr[4]+1 , 1})) 
                        q.offer(new int[] {curr[0]-1,curr[1]+1, curr[2], curr[3], curr[4]+1 , 1});
                }
                if(curr[0] < N-1 && board[curr[2]+1][curr[3]] ==0 && board[curr[2]+1][curr[3]-1]==0){
                    if(contains(vlist, new int[] {curr[0], curr[1], curr[2]+1, curr[3]-1, curr[4]+1, 1})) 
                        q.offer(new int[] {curr[0], curr[1], curr[2]+1, curr[3]-1, curr[4]+1, 1});
                }
                if(curr[0] < N-1 && board[curr[0]+1][curr[1]] ==0 && board[curr[0]+1][curr[1]+1]==0){
                    if(contains(vlist, new int[] { curr[2], curr[3], curr[0]+1, curr[1]+1, curr[4]+1, 1})) 
                        q.offer(new int[] { curr[2], curr[3], curr[0]+1, curr[1]+1, curr[4]+1, 1});
                }
            }
            // |
            else{
                for(int d =0; d<4; d++){
                    int li = curr[0]+di[d];
                    int lj = curr[1]+dj[d];
                    int ri = curr[2]+di[d];
                    int rj = curr[3]+dj[d];
                    if(li>=0 && lj>=0 && ri>=0 && rj>=0 && li<N && lj<N && ri<N && rj<N && board[li][lj]==0 && board[ri][rj]==0){
                       if(contains(vlist, new int[] {li,lj,ri,rj})) q.offer(new int[] {li,lj,ri,rj,curr[4]+1, 1});
                    }
                }
                //회전
                if(curr[1] > 0 && board[curr[2]][curr[3]-1]==0 && board[curr[2]-1][curr[3]-1]==0 ){
                    if(contains(vlist, new int[]{curr[2]-1, curr[3]-1, curr[0], curr[1], curr[4]+1, 0})) 
                    q.offer(new int[]{curr[2]-1, curr[3]-1, curr[0], curr[1], curr[4]+1, 0});
                }
                if(curr[1] < N-1 && board[curr[2]][curr[3]+1]==0 && board[curr[2]-1][curr[3]+1]==0){
                     if(contains(vlist, new int[] {curr[0], curr[1], curr[2]-1, curr[3]+1, curr[4]+1, 0})) 
                    q.offer(new int[] {curr[0], curr[1], curr[2]-1, curr[3]+1, curr[4]+1, 0});
                }
                if(curr[1] > 0 && board[curr[0]][curr[1]-1]==0 &&board[curr[0]+1][curr[1]-1]==0){
                    if(contains(vlist, new int[] {curr[0]+1, curr[1]-1, curr[2],curr[3], curr[4]+1, 0})) 
                    q.offer(new int[]{curr[0]+1, curr[1]-1, curr[2],curr[3], curr[4]+1, 0});
                }
                if(curr[1] < N-1 && board[curr[0]][curr[1]+1]==0 && board[curr[0]+1][curr[1]+1]==0){
                    if(contains(vlist, new int[] {curr[2],curr[3], curr[0]+1, curr[1]+1,curr[4]+1,0})) 
                    q.offer(new int[] {curr[2],curr[3], curr[0]+1, curr[1]+1,curr[4]+1,0});
                }
            } 
            }
            
        }
        
        return answer;
    }
    
    public boolean contains(ArrayList<int[]> list, int[] ia){
        for(int[] l:list){
            int bol = 0;
            for(int i=0; i<4; i++){
                if(l[i] != ia[i]) {
                    bol = 1;
                    break;
                }
            }
            if(bol==0) return false;
        }
        return true;
    }
}
