package swex;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_동철이의프로그래밍대회 {


	 
	 public static void main(String[] args) throws Exception {
	         
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         
	        int T = Integer.parseInt(br.readLine());
	        for(int tc=1; tc<=T; tc++) {
	            String[] s= br.readLine().split(" ");
	            int N = Integer.parseInt(s[0]);
	            int M = Integer.parseInt(s[1]);
	            int[][] ia = new int[N][M];
	            int max = 0; 
	            int count = 0;
	            for(int i=0; i<N; i++) {
	                String[] t = br.readLine().split(" ");
	                int ct = 0; 
	                for(int j=0; j<M; j++) {
	                    ia[i][j] = Integer.parseInt(t[j]);
	                    if(ia[i][j]==1) {
	                        ct++;
	                    }
	                }
	                if(ct>max) {
	                    max = ct;
	                    count = 1;
	                }
	                else if(ct == max) count++;
	            }
	            System.out.println("#"+tc+" "+count+" "+max);
	        }
	    }
	}

