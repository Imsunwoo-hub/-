package programmers;

class Solution_올바른괄호의갯수 {
    
    int answer;
    
    public int solution(int n) {
        answer = 0;
        
        dfs("", 0, n);
        
        return answer;
    }
    
    public void dfs(String s, int c, int n){
        if(c>=n*2){
            int cnt = 0;
            //System.out.println(s);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='(') cnt++;
                else {
                    cnt--;
                    if(cnt<0) return;
                }
            }
            if(cnt!=0) return;
            
            answer++;
            
            return;
        }
        dfs(s+")", c+1, n);
        dfs(s+"(", c+1, n);
    }
}