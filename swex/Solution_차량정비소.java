package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
 
public class Solution_차량정비소 {
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);
            int A = Integer.parseInt(s[3])-1;
            int B = Integer.parseInt(s[4])-1;
            int[] aa = new int[N];
            String[] a = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                aa[i] = Integer.parseInt(a[i]);
            }
            int[] ba = new int[M];
            String[] b = br.readLine().split(" ");
            for(int i=0; i<M; i++) {
                ba[i] = Integer.parseInt(b[i]);
            }
            int[] ta = new int[K];
            String[] t = br.readLine().split(" ");
            for(int i=0; i<K; i++) {
                ta[i] = Integer.parseInt(t[i]);
            }
            int time = 0;
            int idx = 0;
            int[][] result = new int[K][2];
            Queue<Integer> fq = new LinkedList<>();
            // 0: 사람 번호 1: 대기시간  2: 접수대 번호  
            PriorityQueue<int[]> sq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int r = Integer.compare(o1[1], o2[1]);
                    if(r==0) r = Integer.compare(o1[2], o2[2]);
                    return r;
                }
            });
            int va[][] = new int[N][2];
            int vb[][] = new int[M][3];
            while(idx<K) {
                for(int i=0; i<K; i++) {
                    if(ta[i]==time) {
                        fq.offer(i);
                        ta[i] = -1;
                    }
                    if(ta[i] > time) break;
                }
                if(!fq.isEmpty()) {
                    for(int i=0; i<N; i++) {
                        if(va[i][0]==0) {
                            int k = fq.poll();
                            va[i][0] = aa[i];
                            va[i][1] = k;
                            if(fq.isEmpty()) break;
                        }
                    }
                }
                 
                if(!sq.isEmpty()) {
                    for(int i =0; i<M; i++) {
                        if(vb[i][0]==0) {
                            int[] k = sq.poll();
                            vb[i][0] = ba[i];
                            vb[i][1] = k[0];
                            vb[i][2] = k[2];
                            if(sq.isEmpty()) break;
                        }
                    }
                }
             
                time++;
                for(int i=0; i<N; i++) {
                    if(va[i][0] != 0) {
                        va[i][0]--;
                        if(va[i][0]==0) {
                            sq.offer(new int[] {va[i][1], time, i});
                            va[i][0]=0;
                            va[i][1]=0;
                        }
                    }
                }
                for(int i=0; i<M; i++) {
                    if(vb[i][0] != 0) {
                        vb[i][0]--;
                        if(vb[i][0]==0) {
                            result[vb[i][1]][0] = vb[i][2];
                            result[vb[i][1]][1] = i;
                            idx++;
                            vb[i][0] = 0;
                            vb[i][1] = 0;
                            vb[i][2] = 0;
                        }
                    }
                }
                 
            }
            int ret = 0;
            for(int i=0; i<K; i++) {
                if(result[i][0]==A && result[i][1]==B) {
                    ret += i+1;
                }
            }
            if(ret==0) ret=-1;
            System.out.println("#"+tc+" "+ret);
        }
 
    }
 
}

