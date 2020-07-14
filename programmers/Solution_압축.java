package programmers;

import java.util.*;
class Solution_압축 {
  public int[] solution(String msg) {
      int[] temp = new int[1009];
      ArrayList<String> dic = new ArrayList<>(); 
      int aidx = 0;
      for(int i='A'; i<='Z'; i++){
          String s = (char)i + "";
          dic.add(s);
      }
      int i;
      for(i=0; i<msg.length(); i++){
        String c1 = "";
        String c2 = msg.charAt(i)+"";
        for(int j=i; j<msg.length(); j++){
            c1 += msg.charAt(j);
            if(dic.contains(c1)){
                c2 = c1;
                if(j==msg.length()-1){
                    for(int k=0; k<dic.size(); k++){
                    if(c2.equals(dic.get(k))){
                    temp[aidx++] = k+1;
                    break;
                 }
               }
                i=j;
            }
            }
            else {
            dic.add(c1);
                for(int k=0; k<dic.size(); k++){
                if(c2.equals(dic.get(k))){
                temp[aidx++] = k+1;
                break;
             }
            }
            i = j-1;
            break;
            }
        }
     }
      
      int[] answer = new int[aidx];
      for(int j=0; j<aidx; j++){
          answer[j] = temp[j];
      }
      System.out.println(Arrays.toString(answer));
   
      return answer;
  }
}
