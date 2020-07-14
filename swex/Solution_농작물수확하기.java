package swex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_농작물수확하기 {

	public static void main(String[] args) throws Exception {
       
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T  =  Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++)
        {   
            int N =  Integer.parseInt(br.readLine());
            int result = 0;
            int mid = N/2;
            int[][] ia = new int[N][N];
             
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                String[] ar = s.split("");
                for(int j=0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(ar[j]);
                }
            }
            for(int i=0; i<mid; i++) {
                for(int j=mid-i; j<=i+mid; j++) {
                    result += ia[i][j];
                }
            }
            for(int i=mid; i<N; i++) {
                for(int j=i-mid; j<N-(i-mid); j++) {
                    result += ia[i][j];
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}
