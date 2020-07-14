package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_활주로건설 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] s= br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int X = Integer.parseInt(s[1]);
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                for(int j =0; j<N; j++) {
                    map[i][j] = Integer.parseInt(t[j]);
                }
            }
            int ans = 0;
            int j=0;
            for(int i = 0; i < N; i++) {
                int cnt = 1;
                for(j = 0; j < N-1; j++) {
                    if(map[i][j] == map[i][j+1]) cnt++;
                    else if(map[i][j] + 1 == map[i][j+1] && cnt >= X) cnt = 1;
                    else if(map[i][j] - 1 == map[i][j+1] && cnt >= 0) cnt = -X+1;
                    else break;
                }
                if(j == N-1 && cnt >= 0) ans++;
                 
                cnt = 1;
                for(j = 0; j < N-1; j++) {
                    if(map[j][i] == map[j+1][i]) cnt++;
                    else if(map[j][i] + 1 == map[j+1][i] && cnt >= X) cnt = 1;
                    else if(map[j][i] - 1 == map[j+1][i] && cnt >= 0) cnt = -X+1;
                    else break;
                }
                if(j == N-1 && cnt >= 0) ans++;
            }
            System.out.println("#"+tc+" "+ans);
             
        }
 
    }
 
}

