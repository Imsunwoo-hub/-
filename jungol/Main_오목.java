package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_오목{
 
    public static void main(String[] args) throws Exception {
     
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int[][] ia = new int[19][19];
         
        for(int i=0; i<19; i++) {
            String[] s = br.readLine().split(" ");
             
            for(int j=0; j<19; j++) {
                ia[i][j] = Integer.parseInt(s[j]);
            }
        }
         
        int winner = 0;
        int si = -1;
        int sj = -1;
        //          
        int[] di = {-1, -1, -1, 0, 1, 1, 1,  0};
        int[] dj = {-1,  0,  1, 1, 1, 0,-1, -1};
         
        for(int i=0; i<ia.length; i++) {
            for(int j=0; j<ia[i].length; j++) {
                if(ia[i][j] != 0 ) {
                    int a = ia[i][j];
                    for(int d=0; d<di.length; d++) {
                        int count = 1;
                        int ni = i;
                        int nj = j;
                         
                        while(true) {
                            ni += di[d];
                            nj += dj[d];
                            if(ni<0 || nj<0 || ni>18 || nj>18) break;
                            if(ia[ni][nj] == a ) {
                                count++;
                            }
                            else if(ia[ni][nj] != a ) {
                                break;
                            }
                        }
                        if(count==5) {
                             
                            int x = i - di[d]; 
                            int y = j - dj[d];
                            if(x<0 || j<0 || x>= 19 || y>=19  ) {
                                winner = a;
                                if(si==-1 && sj==-1) {
                                    si = i;
                                    sj = j;
                                }
                                else if(si != -1 && sj != -1) {
                                    if(j<sj) {
                                        si = i;
                                        sj = j;
                                    }
                                    else if(j == sj) {
                                        if(i<si) {
                                            si = i;
                                            sj = j;
                                        }
                                    }
                                }
 
                            }
                             
                            else if((x>=0 && x<19 && y>=0 && y<19 && ia[x][y] != a)) {
                                winner = a;
                                if(si==-1 && sj==-1) {
                                    si = i;
                                    sj = j;
                                }
                                else if(si != -1 && sj != -1) {
                                    if(j<sj) {
                                        si = i;
                                        sj = j;
                                    }
                                    else if(j == sj) {
                                        if(i<si) {
                                            si = i;
                                            sj = j;
                                        }
                                    }
                                }
                                 
                            }
                             
                        }
                    }   
                }
             
            }
             
        }
         
        if(winner==0) System.out.println(winner);
        else {
            si +=1;
            sj +=1;
            System.out.println(winner);
            System.out.println(si+" "+sj);
        }
         
         
 
    }
 
}

