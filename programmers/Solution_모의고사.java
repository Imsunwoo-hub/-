package programmers;

public class Solution_모의고사 {
    public int[] solution(int[] answers) {
        int answer = 0;
        int[] a = {};
        int A = 9610009;
        char B = '4';
        for(int i=1; i<=A; i++){
            String s = Integer.toString(i);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == B ){
                    answer++;
                }
            }
        }
        System.out.print(answer);
        return a;
    }
   
}