package programmers;

import java.util.*;

public class Solution_괄호변환 {
    
    int idx;
    
    public boolean solve(String s){
        boolean bol = true;
        Queue<Character> q = new LinkedList<>();
        int l = 0;
        int r = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') {
                l++;
                q.offer('(');
            }
            else {
                r++;
                if(q.isEmpty()){
                    bol = false;
                }
                else{
                    q.poll();
                }
            }
            if(l==r) {
                idx = i+1;
                return bol;
            }
        }
        
        return bol;
    }
    
    public String solution(String p) {
        if(p.length()==0) return p;
        boolean bol = solve(p);
        String u = "";
        String v = "";
        for(int i=0; i<p.length(); i++){
            if(i<idx) u += p.charAt(i); 
            else v += p.charAt(i);
        }
        if(bol) return  u + solution(v);
        
        String answer = "(" + solution(v) + ")";
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i)=='(') answer += ')';
            else answer += '(';
        }
        return answer;
    }
}
