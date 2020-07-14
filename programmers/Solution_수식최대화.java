package programmers;

import java.util.*;

class Solution_수식최대화 {
    
    long answer;
    char[] data, tdata;
    ArrayList<String> list;
    
    public long solution(String expression) {
        
        answer = 0;
        String temp = "";
        list = new ArrayList<>();
        Set<Character> oplist = new HashSet<>();
        
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-'  || expression.charAt(i)=='*' ){
                oplist.add(expression.charAt(i));
                list.add(temp);
                temp = "";
                list.add(expression.charAt(i)+"");
            }
            else if(i == expression.length()-1){
                temp += expression.charAt(i);
                list.add(temp);
            }
            else temp += expression.charAt(i);
        }
        
        data = new char[oplist.size()];
      
        
        int idx = 0;
        for(char c:oplist) data[idx++] = c;
        
        perm(0);
        
        return answer;
    }
    
    public void perm(int r) {
        if(r == data.length){
            
            ArrayList<String> tlist = new ArrayList<>();
            
            for(String s:list) tlist.add(s);
           
            for(int i=0; i<data.length; i++){
                char c = data[i];
                
                while(true){
                    int bol = 0;
                     for(int j=0; j<tlist.size(); j++){
                         if(tlist.get(j).equals(c+"")){
                             bol = 1;
                             long a = Long.parseLong(tlist.get(j-1));
                             long b = Long.parseLong(tlist.get(j+1));
                             long n = 0;
                             if(c=='+'){
                                 n = a+b;
                             }
                             else if(c=='-'){
                                 n = a-b;
                             }
                             else {
                                 n = a*b;
                             }
                             tlist.set(j, n+"");
                             tlist.remove(j-1);
                             tlist.remove(j);
                            
                             break;
                         }
                     }
                    if(bol == 0) break;
                }
               
            }
            
            long sum = Math.abs(Long.parseLong(tlist.get(0)));
            if(sum > answer) answer = sum;
            
            return;
        }
        
        for(int i=r; i<data.length; i++){
            swap(r, i);
            perm(r+1);
            swap(r,i);
        }
    }
    
    public void swap(int i, int j){
        if(i==j) return;
        char c = data[i];
        data[i] = data[j];
        data[j] = c;
    }
}
