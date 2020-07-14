package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Solution_핀볼게임 {
 
    public static void main(String[] args) throws Exception {
         
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] wa = new int[10][2];
            Arrays.fill(wa, new int[] {-1,-1});
            int[][] ia = new int[N][N];
             
            for(int i=0; i<N; i++) {
                String[] s = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    ia[i][j] = Integer.parseInt(s[j]);
                    if(ia[i][j] >= 6 && ia[i][j] <= 10) {
                        if(wa[ia[i][j]-6][0] == -1) {
                            wa[ia[i][j]-6] = new int[]{i,j};
                        }
                        else {
                            wa[ia[i][j]-6+5] = new int[]{i,j};
                        }
                    }
                }
            }
            int point = 0;
            int[] di = {-1,1,0,0};
            int[] dj = {0,0,-1,1};
            // 0  상   1 하   2 좌   3 우
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(ia[i][j] == 0) {
                        for(int d=0; d<di.length; d++) {
                            int tp = 0;
                            int way = d;
                            int ni = i;
                            int nj = j;
                             
                            while(true) {
                             
                                ni = ni+di[way];
                                nj = nj+dj[way];
                                 
                                if(ni==i && nj==j) break;
                                 
                                if( ni>=0 && nj>=0 && ni<N && nj<N && ia[ni][nj]==-1) break;
                                // 벽 
                                if(ni<0 || nj<0 || ni>=N || nj >=N) {
                                    tp++;
                                    switch(way) {
                                    case 0:
                                        way = 1;
                                        break;
                                    case 1: 
                                        way = 0;
                                        break;
                                    case 2:
                                        way = 3;
                                        break;
                                    case 3: 
                                        way = 2;
                                        break;
                                    }
                                    continue;
                                }
                             
                                // 블록 
                                if(ia[ni][nj] >=1 && ia[ni][nj] <= 5) {
                                    tp++;
                                    int block = ia[ni][nj];
                                    switch(block) {
                                    case 1: 
                                        if(way==0 || way== 3) {
                                             
                                            switch(way) {
                                            case 0:
                                                way = 1;
                                                break;
                                            case 1: 
                                                way = 0;
                                                break;
                                            case 2:
                                                way = 3;
                                                break;
                                            case 3: 
                                                way = 2;
                                                break;
                                            }
                                        }
                                        else if(way==1) {
                                            way = 3;
                                        }
                                        else if(way==2) {
                                            way = 0;
                                        }
                                        break;  
                                    case 2:
                                        if(way==1 || way==3) {
                                             
                                            switch(way) {
                                            case 0:
                                                way = 1;
                                                break;
                                            case 1: 
                                                way = 0;
                                                break;
                                            case 2:
                                                way = 3;
                                                break;
                                            case 3: 
                                                way = 2;
                                                break;
                                            }
                                        }
                                        else if(way==0) way = 3;
                                        else if(way==2) way = 1;
                                        break;  
                                    case 3: 
                                        if(way==1 || way==2) {
                                             
                                            switch(way) {
                                            case 0:
                                                way = 1;
                                                break;
                                            case 1: 
                                                way = 0;
                                                break;
                                            case 2:
                                                way = 3;
                                                break;
                                            case 3: 
                                                way = 2;
                                                break;
                                            }
                                        }
                                        else if(way==0) way=2;
                                        else if(way==3) way=1;
                                        break;  
                                    case 4: 
                                        if(way==0 || way==2) {
                                             
                                            switch(way) {
                                            case 0:
                                                way = 1;
                                                break;
                                            case 1: 
                                                way = 0;
                                                break;
                                            case 2:
                                                way = 3;
                                                break;
                                            case 3: 
                                                way = 2;
                                                break;
                                            }
                                        }
                                        else if(way==1) way=2;
                                        else if(way==3) way=0;
                                        break;  
                                    case 5: 
                                         
                                        switch(way) {
                                        case 0:
                                            way = 1;
                                            break;
                                        case 1: 
                                            way = 0;
                                            break;
                                        case 2:
                                            way = 3;
                                            break;
                                        case 3: 
                                            way = 2;
                                            break;
                                        }
                                        break;  
                                    }
                                    continue;
                                }
                                 
                                // 웜홀
                                if(ia[ni][nj] >= 6 && ia[ni][nj] <= 10) {
                                    int idx = ia[ni][nj] - 6;
                                    if(ni == wa[idx][0] && nj == wa[idx][1]) {
                                        ni = wa[idx+5][0];
                                        nj = wa[idx+5][1];
                                    }
                                    else {
                                        ni = wa[idx][0];
                                        nj = wa[idx][1];
                                    }
                                    continue;
                                }
                         
                                 
                                 
                            }
                            if(tp > point) point = tp;
                        }
                    }
                }
            }
         
            System.out.println("#"+tc+" "+point);
        }
 
    }
 
}
