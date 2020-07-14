package programmers;

public class Solution_단체사진찍기 {
	  
	  char[] ca;
	  int answer;
	    
	  public int solution(int n, String[] data) {
	      answer = 0;
	      ca = new char[]{'A','C','F','J','M','N','R','T'};
	      perm(0, data);
	      return answer;
	  }
	    
	 public void perm(int r, String[] data){
	    if(r==8){
	        int bol = 0;
	        for(int i=0; i<data.length; i++){
	            String d = data[i];
	            char a = d.charAt(0);
	            char b = d.charAt(2);
	            char c = d.charAt(3);
	            int e = d.charAt(4)-'0';
	            int x = 0;
	            int y = 0;
	            for(int j=0; j<8; j++){
	                if(ca[j] == a) x = j;
	                if(ca[j] == b) y = j;
	            }
	            int res = Math.abs(x-y)-1;
	            if(c=='='){
	                if(res != e){
	                    bol = 1;
	                    break;
	                }
	            }
	            else if(c == '>'){
	                if(res<=e){
	                     bol = 1;
	                    break;
	                }
	            }
	            else if(c=='<'){
	                if(res>=e){
	                     bol = 1;
	                    break;
	                }
	            }
	        }
	        if(bol==0) answer++;
	        return;
	    }
	     for(int i=r; i<8; i++){
	         swap(i, r);
	         perm(r+1,data);
	         swap(i, r);
	     }
	}
	    public void swap(int i, int j){
	        if(i==j) return;
	        char c = ca[i];
	        ca[i] = ca[j];
	        ca[j] = c;
	    }
	}
