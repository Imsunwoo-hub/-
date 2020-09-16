package programmers;


public class Solution_단어퍼즐 {
    public int solution(String[] strs, String t) {
        int answer = -1;
        int[] dp = new int[t.length()];
        
        for(int i=0; i<t.length(); i++){
            int max = t.length()+1;
            char c = t.charAt(i);
            dp[i] = max;
            
            for(int j=0; j<strs.length; j++){
                int len = strs[j].length()-1;
                char str = strs[j].charAt(len);
                int bol = 0;
                if(c==str){
                    for (int k = 0; k <= len; k++) { 
                        if(i-k<0) {
                            bol = 1;
                            break;
                        }
                        if (t.charAt(i-k) != strs[j].charAt(len-k)) {
                            bol = 1;
                            break;
                        }
                    }
                    if(bol==0){
                        if (i - len - 1 == -1) { 
						    dp[i] = 1;
					    }
					    else {
						    if (dp[i - len - 1] + 1 < dp[i]) { 
							    dp[i] = dp[i - len - 1] + 1;
						    }
					    }
                    }
                }
            }
        }
        if(dp[t.length()-1] >= t.length()+1 ) answer = -1;
        else answer = dp[t.length()-1];
        
        return answer;
    }
}
