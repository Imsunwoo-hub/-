package programmers;

import java.util.*;
class Solution_불량사용자 {
    
    int answer, n,c;
    String[] u,b, data;
    ArrayList<String[]> list;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        u = user_id;
        b = banned_id;
        n = user_id.length;
        c = banned_id.length;
        data = new String[c];
        list = new ArrayList<>();
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int be, int count){
        if(count == c){
            for(int i=0; i<c; i++) {
				for(int j=i+1; j<c; j++) {
					if(data[i]==data[j]) return;
				}
			}
            
           
            
            int bol = 0;
            for(int i=0; i<c; i++){
                
                if(data[i].length() != b[i].length()) {
                    bol = 1;
                    break;
                }
                else {
                    for(int j=0; j<data[i].length(); j++){
                        if(b[i].charAt(j) != '*'){
                            if(data[i].charAt(j) != b[i].charAt(j)){
                                bol = 1;
                                break;
                            }
                        }
                    }
                }
            }
            if(bol == 0) {
                 String[] temp = new String[c];
            for(int i=0; i<c; i++){
                temp[i] = data[i];
            }
            Arrays.sort(temp);
            for(int i=0; i<list.size(); i++){
                int co = 0;
                String[] s = list.get(i);
                for(int j=0; j<s.length; j++){
                    if(temp[j].equals(s[j])) co++;
                }
                if(co == temp.length) return;
            }
            //System.out.println(Arrays.toString(data));
            list.add(temp);
                answer++;
            }
            return;
        }
        
        for(int i=0; i<n; i++){
            data[count] = u[i];
            dfs(i,count+1);
        }
    }
   
}