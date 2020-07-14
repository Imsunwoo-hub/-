package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import java.util.LinkedList;
import java.util.Queue;
 
public class Main_화염에서탈출 {
     
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
    public static int[][] v1,v2;
    public static int count,R,C;
    public static char[][] ca;
     
    public static Queue<int[]> fq;
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
         
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        fq = new LinkedList<int[]>();
        ca = new char[R][C];
         
        int pi = 0;
        int pj = 0;
         
         
        for(int i=0; i<R; i++) {
            String t = br.readLine();
            for(int j=0; j<C; j++) {
                ca[i][j] = t.charAt(j);
                if(ca[i][j]=='*') {
                    fq.offer(new int[] {i,j});
                }
                if(ca[i][j]=='S') {
                    pi = i;
                    pj = j;
                }
            }
        }
        //System.out.println(pi+" "+pj+" "+fi+" "+fj);
        count = 0;
        //System.out.println(fq.size());
        bfs(pi,pj);
        /*for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(ca[i][j]);
            }
            System.out.println();
        }*/
     
        if(count==0) System.out.println("impossible");
        else System.out.println(count);
    }
     
     
    public static void bfs(int pi, int pj) {
        v1 = new int[R][C];
        v2 = new int[R][C];
         
        Queue<int[]> pq = new LinkedList<int[]>();
        //System.out.println(fq.size());
        pq.offer(new int[] {pi,pj,0});
        int fc=0;
        int pc = 0;
        while(!pq.isEmpty()) {
            if(!fq.isEmpty()) {
                 
                fc  = fq.size();
                while(fc>0) {
                int[] f = fq.poll();
                fc--;
                int nfi = f[0];
                int nfj = f[1];
                if(v1[nfi][nfj]==0) {
                    v1[nfi][nfj] = 1;
                    for(int d=0; d<4; d++) {
                        int ni = f[0]+di[d];
                        int nj = f[1]+dj[d];
                        if(ni>=0 && ni<R && nj>=0 && nj<C && ca[ni][nj]=='.' && v1[ni][nj]==0) {
                            ca[ni][nj] = '*';
                            fq.offer(new int[] {ni,nj});
                            }
                        }
                    }
                }
            }
            pc = pq.size();
            while(pc>0) {
                int[] p = pq.poll();
                pc--;
                int npi = p[0];
                int npj = p[1];
                if(ca[npi][npj]=='D') {
                    if(count == 0)count = p[2];
                    else {
                        if(p[2]<count) count = p[2];
                    }
                     
                }
                if(v2[npi][npj]==0) {
                    v2[npi][npj]=1;
                    for(int d=0; d<4; d++) {
                        int ni = p[0]+di[d];
                        int nj = p[1]+dj[d];
                        if(ni>=0 && ni<R && nj>=0 && nj<C && v2[ni][nj]==0) {
                            if(ca[ni][nj]=='.' || ca[ni][nj]=='D' ) {
                                pq.offer(new int[] {ni,nj,p[2]+1});
                            }
                        }
                    }
                }
            }
        }
         
    }
         
}

