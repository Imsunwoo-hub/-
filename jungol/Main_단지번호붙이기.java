package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main_단지번호붙이기 {
     
    public static int count, idx,N,c, count_a[], ia[][], v[][]; 
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
 
    public static void main(String[] args) throws Exception {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ia = new int[N][N];
        v = new int[N][N];
        count_a = new int[N*N];
        count = 0;
        idx = 0;
         
        for(int i=0; i<N; i++) {
            String s = br.readLine(); 
            for(int j=0; j<N; j++) {
                ia[i][j] = s.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++ ) {
                if(ia[i][j]==1 && v[i][j] == 0) {
                    //v[i][j] = 1;
                    count ++;
                    bfs(i,j);
                }
            }
        }
        Arrays.sort(count_a);
        System.out.println(count);
        for(int i : count_a ) {
            if(i!=0) {
                System.out.println(i);
            }
        }
    }
     
    public static void bfs(int i, int j) {
        int cnt=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);
        while(!queue.isEmpty()) {
            int curr1 = queue.poll();
            int curr2 = queue.poll();
             
            if(v[curr1][curr2]==0 ) {
                v[curr1][curr2] = 1;
                cnt++;
                for(int d=0; d<di.length; d++) {
                    int ni = curr1+di[d];
                    int nj = curr2+dj[d];
                    if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == 0 && ia[ni][nj] == 1 ) {
                        queue.offer(ni);
                        queue.offer(nj);
                    }
                }
            }
        }
        count_a[idx++] = cnt;
    }
}

