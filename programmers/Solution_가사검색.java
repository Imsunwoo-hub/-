package programmers;

import java.util.Arrays;

class Trie{
    Trie[] node = new Trie[26];
    int cnt = 0;
    
    void insert(String s, int idx, int bol){
        cnt++;
        if(bol==1){
            if(idx >= s.length()) return;
        }
        if(bol== -1){
            if(idx < 0) return;
        }
        int alpa = s.charAt(idx)-'a';
        if(node[alpa]==null) {
            node[alpa] = new Trie();
        }
        node[alpa].insert(s, idx+bol, bol);
    }
    
    int find(String s, int idx, int bol) {
    	int answer = 0;
    	int alpa = s.charAt(idx)-'a';
    	if(s.charAt(idx)=='?') return cnt;
    	if(node[alpa]== null) return 0;
    	
    	
    	answer = node[alpa].find(s, idx+bol, bol);
    	
    	
    	
    	return answer;
    }
    
}

public class Solution_가사검색 {
	
	 	
	
	    public static int[] solution(String[] words, String[] queries) {
	        int[] answer = new int[queries.length];
	        
	        Trie[] lt = new Trie[10001];
		 	Trie[] rt = new Trie[10001];
		 	
		 	for(int i=0; i<10001; i++) {
		 		lt[i] = new Trie();
		 		rt[i] = new Trie();
		 	}
	       
	        for(int i=0; i<words.length; i++){
	            int size = words[i].length();
	            lt[size].insert(words[i], 0, 1);
	            rt[size].insert(words[i], size-1 ,-1);
	        }
	        
	        for(int i=0; i<queries.length; i++) {
	        	int size = queries[i].length();
	        	if(queries[i].charAt(0)=='?') {
	        		answer[i] = rt[size].find(queries[i], size-1, -1);
	        	}
	        	if(queries[i].charAt(size-1)=='?') {
	        		answer[i] = lt[size].find(queries[i], 0, 1);
	        	}
	        }
	        
	        return answer;
	    }

	public static void main(String[] args) {
		
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] q = {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(Arrays.toString(solution(words, q)));

	}

}
