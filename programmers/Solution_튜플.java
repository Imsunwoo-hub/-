package programmers;

import java.util.*;

public class Solution_튜플 {
    public int[] solution(String s) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       
        String temp = "";
        ArrayList<Integer> tlist = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != '{' && c != ',' && c!='}') temp += c;
            if(c == ',') {
                if(temp.length() !=0 ){
                    tlist.add(Integer.parseInt(temp));
                    temp = "";
                }
            }
            if(c == '}') {
                if(temp.length() !=0 ){
                     tlist.add(Integer.parseInt(temp));
                     temp = "";
                }
                if(tlist.size()!=0){
                    list.add(tlist);
                    tlist = new ArrayList<>();
                }
            }
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					return Integer.compare(o1.size(), o2.size());
				}
			});
        ArrayList<Integer> res = new ArrayList<>(); 
        for(ArrayList<Integer> l : list) {
            for(int i : l) {
                if(!res.contains(i)) res.add(i);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
