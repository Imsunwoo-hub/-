package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main_도서관 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
         
        int[][] ia = new int[N][2];
         
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            ia[i][0] = Integer.parseInt(s[0]);
            ia[i][1] = Integer.parseInt(s[1]);
        }
         
        Arrays.sort(ia, new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
             
        });
        int out = 0;
        int min = ia[0][0];
        int max = ia[0][1];
        int in = 0;
        for(int i=1; i<N; i++) {
             
            if(ia[i][0] >= min && ia[i][0] <= max) {
                if(max < ia[i][1]) max = ia[i][1];
            }
            else {
                if(ia[i][0] - max > out) out = ia[i][0] - max ;
                if((max - min) > in) in = max - min;
                max = ia[i][1];
                min = ia[i][0];
            }
            if(i==N-1) {
                if((max - min) > in) in = max - min;
            }
        }
        System.out.println(in + " " + out);
         
 
    }
 
}

