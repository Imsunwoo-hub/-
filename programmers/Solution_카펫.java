package programmers;

public class Solution_카펫 {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int idx = 0;
        for(int i=3; i <= (red+brown)/3; i++){
            for(int j=i; j <= (red+brown)/3; j++){
                if(i*j==brown+red){
                    if((i-2) * (j-2) == red ){
                    answer[idx++] = j;
                    answer[idx++] = i;
                    break;
                    }
                }
            }
            if(idx == 2 ) break;
        }
        
        return answer;
    }
}
