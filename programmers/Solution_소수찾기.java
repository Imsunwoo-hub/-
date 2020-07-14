package programmers;

import java.util.*;

public class Solution_소수찾기 {

    int[] data;
    Set<String> set;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        for(int i=1; i<=numbers.length(); i++){
            data = new int[i];
            comb(i, numbers.length(), numbers);
        }
        for(String s : set){
            int num = Integer.parseInt(s);
            if(num < 2) continue;
            if(num==2){
                answer++;
                continue;
            }
            int bol=0;
            for(int i=2; i<num; i++){
                if(num%i==0){
                    bol=1;
                    break;
                }
            }
            if(bol==0) answer++;
        }
        return answer;
    }
    
    public void comb(int c, int n, String nums){
        if(n<c) return;
        if(c==0){
            perm(0, data.length );
            return;
        }
        data[c-1] = nums.charAt(n-1) - '0';
        comb(c-1,n-1, nums);
        comb(c,  n-1, nums);
    }
        
    public void perm(int c, int n){
        if(c==n){
            String temp = "";
            for(int i=0; i<n; i++){
                if(temp.length()==0 && data[i]==0) continue;
                
                temp += data[i]+"";
            }
            if(temp.length() == 0 ) return;
            set.add(temp);
            return;
        }
        
        for(int i=c; i<n; i++){
                swap(i,c);
                perm(c+1, n);
                swap(i,c);
        }
    }
    
    public void swap(int i, int j){
        if(i==j) return;
        int c = data[i];
        data[i] = data[j];
        data[j] = c;
    }
    
}