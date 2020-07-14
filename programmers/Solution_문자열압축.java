package programmers;

import java.util.*;
public class Solution_문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        int end = 1;
        ArrayList<String> list = null;
        
        while(end < len){
            
            list = new ArrayList<>();
            String temp = "";
            for(int i=0; i<=s.length()-end; i+=end){
                temp = "";
                for(int j=i; j<i+end; j++){
                    temp += s.charAt(j);
                }
                list.add(temp);
            }
         
            if(s.length()%end != 0 ){
                 temp = "";
                 for(int i=s.length()-s.length()%end; i<s.length(); i++){
                    temp+=s.charAt(i);
                }
                if(!temp.equals("")) list.add(temp);
            }
           
            
            String st = "";
            int start = 0;
            
            while(start < list.size()){
                int count = 0;
                String t = list.get(start);
                int bol = 0;
                for(int i=start; i<list.size(); i++){
                    if(t.equals(list.get(i))) {
                        count++;
                    }
                    else {
                        if(count<=1){
                            st += t;
                        }
                        else {
                            st += count+t;
                        }
                        bol = 1;
                        start = i;
                        break;
                    }
                }
                if(bol == 0) {
                    if(count>1) st += count+t;
                    else st += t;
                    break;
                }
            }
            
            if(st.length() < answer) answer = st.length();
            
            end++;
            
        }
        return answer;
    }
}
