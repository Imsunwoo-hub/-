package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main_냉장고 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int N = Integer.parseInt(br.readLine());
        int[][] ia = new int[N][2];
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            ia[i][0] = Integer.parseInt(s[0]);
            ia[i][1] = Integer.parseInt(s[1]);
        }
        int count = 1;
        Arrays.sort(ia,new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
                 
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int end =0;
        for(int i=1; i<N; i++) {
            for(int j=i-1; j>=end; j--) {
                if((ia[i][0] >= ia[j][0] && ia[i][0] <= ia[j][1]) ||
                        ia[i][1] >= ia[j][0] && ia[i][1] <= ia[j][1]) {
                    continue;
                }
                else {
                    end = i;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
 
}

