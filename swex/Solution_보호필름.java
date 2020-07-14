package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_보호필름{
     
    public static int D,W,K,ia[][] , tia[][],v[], result;
 
    public static void main(String[] args) throws Exception {
         
    	System.setIn(new FileInputStream("res/input_d9_2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            D = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[1]);
            K = Integer.parseInt(s[2]);
            ia = new int[D][W];
            tia = new int[D][W];
            v = new int[D];
            for(int i=0; i<D; i++) {
                String[] t = br.readLine().split(" ");
                for(int j=0; j<W; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                    tia[i][j] = Integer.parseInt(t[j]);
                }
            }
            result = Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+tc+" "+result);
        }
    }
     
    public static void dfs(int i, int c) {
        if(c>=result) return;
        if(i==D) {
	        int bol = 0;
	        for(int x=0; x<W; x++) {
	            int b = 0;
	            int idx = 0;
	            for(int y=idx; y<D-K+1; y++) {
	                int val = tia[y][x];
	                int tempc = 0;
	                for(int k=y; k<y+K; k++) {
	                    if(val == tia[k][x]) tempc++;
	                    else {
	                    	idx = k;
	                    	break;
	                    }
	                }
	                if(tempc >= K) {
	                    bol++;
	                    b=1;
	                    break;
	                }
	            }
	            if(b==0) break;
	        }
	        if(bol==W) {
	            if(c < result) result = c;
	            return;
	        }
	        return;
        }
		/*
		 * dfs(i+1,c); for(int y=0; y<W; y++) { tia[i][y] = 0; } dfs(i+1,c+1); for(int
		 * y=0; y<W; y++) { tia[i][y] = ia[i][y]; } for(int y=0; y<W; y++) { tia[i][y] =
		 * 1; } dfs(i+1, c+1); for(int y=0; y<W; y++) { tia[i][y] = ia[i][y]; }
		 */
		
		 else { for(int x=0; x<D; x++) { if(v[x] == 1) continue; for(int y=0; y<W;
		 y++) { tia[x][y] = 0; } v[x] = 1; dfs(x,c+1); for(int y=0; y<W; y++) {
		 tia[x][y] = 1; } dfs(x,c+1); for(int y=0; y<W; y++) { tia[x][y] = ia[x][y]; }
		 v[x] = 0; }
		 
		 return; }
		 
         
    }
     
}
