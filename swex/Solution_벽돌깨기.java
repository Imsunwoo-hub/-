package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_벽돌깨기 {
     
    public static int N,H,W, tia[][],ia[][], d[], result;
     
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            W = Integer.parseInt(s[1]);
            H = Integer.parseInt(s[2]);
            ia = new int[H][W];
            tia = new int[H][W];
            d = new int[N];
            result = Integer.MAX_VALUE;
            for(int i =0; i<H; i++) {
                String[] t = br.readLine().split(" ");
                for(int j = 0; j<W; j++) {
                    ia[i][j] = Integer.parseInt(t[j]);
                }
            }
            product(0);
            System.out.println("#"+tc+" "+result);
        }
         
    }
     
    public static void product(int c) {
        if(c==N) {
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    tia[i][j] = ia[i][j];
                }
            }
            Queue<int[]> q = new LinkedList<>();
            for(int i=0; i<N; i++) {
                int idx = d[i];
                for(int j=0; j<H; j++) {
                    if(tia[j][idx] != 0) {
                        if(tia[j][idx]==1) 
                        {
                            tia[j][idx] = 0;
                            break;
                        }
                        else {
                            q.offer(new int[] {j,idx,tia[j][idx]});
                            while(!q.isEmpty()) {
                                int[] curr = q.poll(); 
                                //위
                                int end = curr[0]-curr[2];
                                if(end<-1) {
                                    end = -1;
                                }
                                for(int a=curr[0]; a>end; a--) {
                                    if(tia[a][curr[1]] > 1) q.offer(new int[] {a,curr[1], tia[a][curr[1]]});
                                    tia[a][curr[1]] = 0;
                                }
                                //아래
                                end = curr[0] + curr[2];
                                if(end>H) end = H;
                                for(int a=curr[0]; a<end; a++) {
                                    if(tia[a][curr[1]]>1) q.offer(new int[] {a,curr[1],tia[a][curr[1]]});
                                    tia[a][curr[1]] = 0;
                                }
                                //왼
                                end = curr[1] -curr[2];
                                if(end<-1) end = -1;
                                for(int b =curr[1]; b>end; b--) {
                                    if(tia[curr[0]][b]>1) q.offer(new int[] {curr[0],b,tia[curr[0]][b]});
                                    tia[curr[0]][b] = 0;
                                }
                                //오른
                                end = curr[1] + curr[2];
                                if(end>W) end = W;
                                for(int b =curr[1]; b<end; b++) {
                                    if(tia[curr[0]][b]>1) q.offer(new int[] {curr[0],b,tia[curr[0]][b]});
                                    tia[curr[0]][b] = 0;
                                }
                            }
                            break;
                        }
                    }
                }
                 
                for(int x=0; x<W; x++) {
                    for(int y=H-1; y>=0; y--) {
                        if(tia[y][x] != 0) {
                            int w = y+1;
                            while(true) {
                                if(w>=H || tia[w][x] != 0) break;
                                w++;
                            }
                            if(w-1<H &&  tia[w-1][x] == 0) {
                                tia[w-1][x] = tia[y][x];
                                tia[y][x] = 0;
                            }
                        }
                    }
                }
         
            }
             
            /*for(int[] t:tia) System.out.println(Arrays.toString(t));
            System.out.println();*/
             
            int count = 0;
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(tia[i][j] != 0) count++;
                }
            }
            if(count<result) result = count;
            return;
        }
         
        for(int i=0; i<W; i++) {
            d[c] = i;
            product(c+1);
        }
    }
 
}

