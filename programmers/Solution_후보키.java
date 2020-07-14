package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_후보키 {
	
	
	static int col, row, answer, d[];
    static ArrayList<String> list;
    
    public static int solution(String[][] relation) {
        answer = 0;
        col = relation.length; 
        row = relation[0].length; 
        list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<row; i++){
            set.clear();
            for(int j=0; j<col; j++){
                set.add(relation[j][i]);
            }
            if(set.size()==col) {
            	list.add(i+"");
            }
        }
        for(int i=1; i<=row; i++) {
        	d = new int[i];
        	comb(row, i, relation);
        }
   
        answer = list.size();
        return answer;
    }    
    
    public static void comb(int n, int c, String[][] relation) {
    	if(n<c) return;
    	if(c==0) {
    		String temp = "";
    		for(int i=0; i<d.length; i++) {
    			temp += d[i]; 
    		}
    		
    		for(int i=0; i<list.size(); i++) {
    			String s = list.get(i);
    			if(temp.length() >= s.length()) {
    				int count = 0;
    				for(int a=0; a<s.length(); a++) {
    					for(int b=0; b<temp.length(); b++) {
    						if(s.charAt(a)==temp.charAt(b)) {
    							count++;
    							break;
    						}
    					}
    				}
    				if(count == s.length()) return;
    			}
    		}
    		//if(list.contains(temp)) return;
    		
    		Set<String> set = new HashSet<>();
    		for(int i=0; i<col; i++) {
    			String t = "";
    			for(int j=0; j<d.length; j++) {
    				t += relation[i][d[j]]; 
    			}
    			set.add(t);
    		}
    		
    		if(set.size()==col) list.add(temp);
    		
    		return;
    	}
    	
    	d[c-1] = row-n;
    	comb(n-1,c-1, relation);
    	comb(n-1,c, relation);
    	
    }
}
