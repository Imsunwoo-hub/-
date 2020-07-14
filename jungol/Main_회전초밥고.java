package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main_회전초밥고 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int c = Integer.parseInt(s[3]);
        Queue<Integer> q = new LinkedList<>();
        int[] ia = new int[N];
        int[] da = new int[d+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            ia[i] = Integer.parseInt(br.readLine());
        }
        int p = 0;
        for(int i=0; i<N+(k-1); i++) {
            if(max == k+1) break;
            q.offer(ia[i%N]);
            da[ia[i%N]]++;
            if(da[ia[i%N]] == 1) p++;
            if(i>=k-1) {
                int tm = p;
                if(da[c] == 0) tm++;
                if(tm > max) max = tm;
                int a = q.poll();
                da[a]--;
                if(da[a]==0) p--;
            }
             
        }
     
        System.out.println(max);
         
    }
 
}

