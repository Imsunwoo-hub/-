package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
 
public class Main_지하철 {
     
    public static int[] ia[], v,d, p;
    public static ArrayList<Integer> rlist;
    public static int min, M,N;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        String[] s = br.readLine().split(" ");
         
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
         
        ia = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] t = br.readLine().split(" ");
            for(int j =0; j<N; j++) {
                ia[i][j] = Integer.parseInt(t[j]);
            }
        }
        v = new int[N];
        d = new int[N];
        p = new int[N];
        //ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            p[i] = -1;
            d[i] = Integer.MAX_VALUE;
        }
        dijkstra(0);
        min = d[M-1];
        System.out.println(min);
        Stack<Integer> st = new Stack<>();
        for(int k=M-1; k!=-1; k=p[k]) {
            st.push(k+1);
        }
        while(!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
         
         
    }
     
    public static void dijkstra(int start) {
        /*for(int i=0; i<N; i++) {
            d[i] = ia[start][i];
        }*/
        v[start] = 1;
        d[start] = 0;
        for(int i=0; i<N-2; i++) {
            int curr = getSmallIndex();
            v[curr] = 1;
            for(int j=0; j<N; j++) {
                if(v[j]==0) {
                    if(d[j] > d[curr]+ia[curr][j]) {
                        d[j] = d[curr]+ia[curr][j];
                        p[j] = curr;
                    }
                }
            }
            //System.out.println(Arrays.toString(d));
        }
         
    }
     
    public static int getSmallIndex() {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<N; i++) {
            if(d[i]<min && v[i]==0) {
                min = d[i];
                idx = i;
            }
        }
        return idx;
    }
     
 
}
