package programmers;

class Solution_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] l = {3,0};
        int[] r = {3,2};
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer += "L";
                l[0] = numbers[i]/3;
                l[1] = 0;
            }
            else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer += "R";
                r[0] = numbers[i]/3-1;
                r[1] =  2;
            }
            else {
                int[] n = new int[2];
                if(numbers[i]==2) n[0] = 0;
                if(numbers[i]==5) n[0] = 1;
                if(numbers[i]==8) n[0] = 2;
                if(numbers[i]==0) n[0] = 3;
                n[1] = 1;
                int ll = Math.abs(l[0]-n[0]) + Math.abs(l[1]-n[1]); 
                int rl = Math.abs(r[0]-n[0]) + Math.abs(r[1]-n[1]); 
                
                if(ll<rl){
                    answer+="L";
                    l[0] = n[0];
                    l[1] = n[1];
                }
                else if(rl<ll){
                    answer+="R";
                    r[0] = n[0];
                    r[1] = n[1];
                }
                else {
                    if(hand.equals("left")){
                         answer+="L";
                        l[0] = n[0];
                        l[1] = n[1];
                    }
                    else{
                        answer+="R";
                        r[0] = n[0];
                        r[1] = n[1];
                    }
                }
            }
        }
        return answer;
    }
}
