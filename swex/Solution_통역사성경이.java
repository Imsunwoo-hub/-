package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_통역사성경이 {
 
    public static void main(String[] args) throws Exception  {
 
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            int[] counta = new int[N];
             
            String s = br.readLine();
            int idx = 0;
            int count = 0;
            int bol = 0;
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                 
                if((c<'a' || c>'z')) bol++;
                if(c>='A'&& c<='Z') {
                    count++;
                    bol--;
                }
                if(c==' ') {
                    bol--;
                    if(count==1 && bol==0) {
                        counta[idx]++;
                        count = 0;
                        bol=0;
                    }
                    else {
                        bol=0;
                        count = 0;
                    }
                }
                if(c=='.'||c=='?'||c=='!') {
                    bol--;
                    if(count==1 && bol==0) {
                        counta[idx]++;
                        count=0;
                        bol=0;
                        idx++;
                    }
                    else {
                        bol=0;
                        count=0;
                        idx++;
                    }
                }
            }
 
             
            System.out.print("#"+tc+" ");
            for(int i:counta) System.out.print(i+" ");
            System.out.println();
        }
    }
 
}
