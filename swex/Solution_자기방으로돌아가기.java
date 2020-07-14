package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
 
public class Solution_자기방으로돌아가기 {
 
    public static void main(String[] args) throws Exception  {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] room = new int[200];
             
            for(int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                int a = (Integer.parseInt(s[0])-1)/2;
                int b = (Integer.parseInt(s[1])-1)/2;
                 
                int ta = a>b?a:b;
                int tb = a>b?b:a;
                 
                for(int j=tb; j<=ta; j++) {
                    room[j]++;
                }   
            }
            System.out.println("#"+tc+" "+Arrays.stream(room).max().getAsInt());
        }
 
    }
 
}

