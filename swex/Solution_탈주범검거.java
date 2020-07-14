package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_탈주범검거 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int N
            = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);
            int R = Integer.parseInt(s[3]);
            int L = Integer.parseInt(s[4]);
            int[][] ia = new int[N][M];
            int[][] v = new int[N][M];
            int[][] run = new int[N][M];
            int co = 0;
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                for(int j=0; j<M; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                    if(ia[i][j]!=0) co++;
                }
            }
            int count = 0;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {C,R,1});
            int[][] di = {{},{-1,1,0,0},{-1,1},{0,0},{-1,0},{1,0},{1,0},{-1,0}};
            int[][] dj = {{},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{0,-1},{0,-1}};
             
            while(!q.isEmpty()) {
                 
                int[] curr = q.poll();
                if(v[curr[0]][curr[1]]==0) {
                    v[curr[0]][curr[1]] = 1;
                    if(curr[2]>L) break;
                    count++;
                     
                    run[curr[0]][curr[1]] = 1;
                //System.out.println(curr[2]+" "+count);
                int i = curr[0];
                int j = curr[1];
                int c = curr[2];
                int w = ia[i][j];
                 
                switch(w) {
                 
                case 1:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj < M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next==1 || next ==2 || next==5 || next==6)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next==1 || next ==2 || next==4 || next==7)) q.offer(new int[] {ni,nj,c+1});
                            if(d==2 && (next==1 || next ==3 || next==4 || next==5)) q.offer(new int[] {ni,nj,c+1});
                            if(d==3 && (next==1 || next ==3 || next==6 || next==7)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                case 2:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj < M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next== 2|| next ==1 || next==5 || next==6)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next== 2|| next ==1 || next==4 || next==7)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                case 3:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj <M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next==3||next ==1 || next==4 || next==5)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next==3||next ==1 || next==6 || next==7)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                case 4:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj <M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next ==1 || next==2 || next==5 || next==6)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next ==1 || next==3 || next==6 || next==7)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                case 5:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj <M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next ==1 || next==2 || next==4 || next==7)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next ==1 || next==3 || next==6 || next==7)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                case 6:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj <M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next ==1 || next==2 || next==4 || next==7)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next ==1 || next==3 || next==5 || next==4)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                 
                    break;
                case 7:
                    for(int d=0; d<di[w].length; d++) {
                        int ni = i+di[w][d]; 
                        int nj = j+dj[w][d]; 
                        if(ni>=0 && nj >=0 && ni<N && nj <M && v[ni][nj]==0 && ia[ni][nj] != 0) {
                            int next = ia[ni][nj];
                            if(d==0 && (next ==1 || next==2 || next==5 || next==6)) q.offer(new int[] {ni,nj,c+1});
                            if(d==1 && (next ==1 || next==3 || next==4 || next==5)) q.offer(new int[] {ni,nj,c+1});
                        }
                    }
                    break;
                }
                }
            /*  for(int[] i : run ) System.out.println(Arrays.toString(i));
                System.out.println();*/
            }
             
            System.out.println("#"+tc+" "+count);
        }
    }
 
}

