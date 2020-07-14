package programmers;

import java.util.*;

public class Solution_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> list = new Stack<>();
        
        for(int m = 0; m< moves.length; m++){
            for(int i=0; i<board[moves[m]-1].length; i++){
                if(board[i][moves[m]-1] != 0){
                    if(list.size()==0) {
                        list.push(board[i][moves[m]-1]);
                        board[i][moves[m]-1] = 0;
                    } else {
                        if(list.peek()==board[i][moves[m]-1]){
                            list.pop();
                            answer+=2;
                        }
                        else{
                            list.push(board[i][moves[m]-1]);  
                        }
                        board[i][moves[m]-1] = 0;
                    }
                   
                    break;
                }
            }
        }
        
        return answer;
    }
}
