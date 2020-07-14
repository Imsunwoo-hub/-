package swex;

import java.io.BufferedReader;
import java.util.Arrays;



public class Solution_문제제목붙이기 {
	public static void main(String[] args) throws Exception {
		 
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc <= T; tc++) {
             
            int result = 0;
            int N = Integer.parseInt(br.readLine());
            String[] sa = new String[N];
            for(int i=0; i<N; i++) {
                sa[i] = br.readLine();
            }
            Arrays.parallelSort(sa);
            int idx = 0;
            char c = 'A';
            int bol = 0;
            while(idx<sa.length-1) {
                for(int i=idx; i<sa.length; i++) {
                    bol=0;
                    if(c==sa[i].charAt(0)) {
                        bol=1;
                        result++;
                        idx=i;
                        break;
                    }
                }
                if(bol==0) break;
                c++;
            }
            System.out.println("#"+tc+" " +result);
        }
    }
}
