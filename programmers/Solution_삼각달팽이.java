package programmers;

import java.util.*;

public class Solution_삼각달팽이 {
    public int[] solution(int n) {
        int[] ia = new int[n+1];
        for(int i=1; i<=n; i++){
            ia[i] = ia[i-1]+i;
        }
        int[] answer = new int[ia[n]];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new int[i+1]);
        int x = 1;
        int bol = 0;
        int i=0;
        int j=0;
        int e = n;
        while(x<=ia[n]){
            if(bol == 0){
                for(int k=0; k<e; k++){
                    list.get(i++)[j] = x++;
                }
                i--;
                j++;
                e--;
                for(int k=0; k<e; k++){
                     list.get(i)[j++] = x++;
                }
                i--;
                j-=2;
                e--;
                bol = 1;
            }
            else {
                for(int k=0; k<e; k++){
                    list.get(i--)[j--] = x++;
                }
                i+=2;
                j++;
                e--;
                bol = 0;
            }
        }
        
        int idx = 0;
        for(int[] l:list){
            for(int k=0; k<l.length; k++){
                answer[idx++] = l[k];
            }
        }
        
        return answer;
    }
}
