package programmers;

public class Solution_풍선터트리기 {
    public int solution(int[] a) {
        int answer = 2;
        int l = a[0];
        int r = a[a.length-1];
        for(int i=0; i<a.length; i++){
            if(l>a[i]){
                answer++;
                l = a[i];
            }   
            if(r>a[a.length-1-i]){
                answer++;
                r = a[a.length-1-i];
            }
        }    
        if(l==r) answer--;
        return answer;
    }
}