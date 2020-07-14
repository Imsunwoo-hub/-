package programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution_다트게임 {
  public int solution(String dartResult) {
      
      int sum[] = new int[3];
      
      String regex = "(\\d{1,2}[S|T|D][*|#]{0,1})";
      Pattern p = Pattern.compile(regex+regex+regex);
      Matcher m = p.matcher(dartResult);
      m.find();
      for (int i=1; i<=m.groupCount(); i++){
          int val = 0;
          Pattern p1 = Pattern.compile("(\\d{1,2})([S|T|D])([*|#]{0,1})");
          Matcher m1 = p1.matcher(m.group(i));
          m1.find();
          
          if("S".equals(m1.group(2))){
              val=1;
          }
          else if("D".equals(m1.group(2))){
              val=2;
          }
          else if("T".equals(m1.group(2))){
              val=3;
          }
          sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), val);
          if("*".equals(m1.group(3))){
              sum[i-1] *=2;
              if(i>1){
                  sum[i-2] *=2;
              }
          }
          else if("#".equals(m1.group(3))){
              sum[i-1] *= (-1);
          }
      }
      
      int answer = sum[0] + sum[1] + sum[2];
      return answer;
  }
}