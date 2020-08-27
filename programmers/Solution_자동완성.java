package programmers;

class Node{
    
    Node[] next;
    int sum;
    Node(){
        next = new Node[26];
        sum = 0;
    }
}

class Solution_자동완성 {
    public int solution(String[] words) {
        int answer = 0;
        
        Node node = new Node();
        
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            Node start = node;
            for(int j=0; j<word.length(); j++){
                if(start.next[word.charAt(j)-'a']==null) start.next[word.charAt(j)-'a'] = new Node();
                start = start.next[word.charAt(j)-'a'];
                start.sum++;
            }
        }
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            Node start = node;
            for(int j=0; j<word.length(); j++){
                start = start.next[word.charAt(j)-'a'];
                if(start.sum > 1) answer ++;
                else {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}