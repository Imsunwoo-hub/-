package programmers;

import java.util.*;
public class Solution_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int hh = 9;
        int mm = 0;
        int idx = 0;
        Arrays.sort(timetable);
       // System.out.println(Arrays.toString(timetable));
        while(n>0){
            int cnt = 0;
            int end = 0;
            int bol = 0;
            if(idx>=timetable.length) break;
            
            for(int i=idx; i<timetable.length; i++){
                String[] s = timetable[i].split(":");
                int hour = Integer.parseInt(s[0]);
                int min = Integer.parseInt(s[1]);
                if(hour < hh || ( hour==hh && min <= mm)) cnt++;
                else if(hour > hh ||( hour <= hh && min>mm)) {
                    end = i;
                    break; 
                }
                if(cnt==m) {
                    bol = 1;
                    end = i;
                    break;
                } 
                end = i;
            }
            
            if(cnt < m) {
                idx += cnt;
                answer = hh+":"+mm;
            }
            else {
                String[] s = timetable[end].split(":");
                int hour = Integer.parseInt(s[0]);
                int min = Integer.parseInt(s[1]);
                if(min-1 < 0) {
                    min += 59;
                    hour -= 1;
                }
                else {
                    min -= 1;
                }    
                answer  = hour+":"+min;
                
                if(bol==1)idx = end+1;
                else idx = end;
            }
          
            hh += (mm+t)/60;
            mm = (mm+t)%60; 
            n--;
        }
        
        String[] s = answer.split(":");
        if(s[0].length()==1) s[0] = "0"+s[0];
        if(s[1].length()==1) s[1] = "0"+s[1];
        answer = s[0]+":"+s[1];
        return answer;
    }
}