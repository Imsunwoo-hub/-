package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
 
public class Solution_최소스패닝트리 {
     
    public static int V, p[];
    public static int INF=Integer.MAX_VALUE/2;
    public static List<int[]> v;
 
    public static void main(String[] args) throws Exception  {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            v = new ArrayList<>(); 
             
            for(int i=0; i<E; i++) {
                String[] t = br.readLine().split(" ");
                v.add(new int[]{Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2])});
                 
                 
            }
             
            long result = kruskal(); 
            System.out.println("#"+tc+" "+result);
        }
    }
     
    public static void makeSet(int i) {
        p[i] = i;
    }
     
    public static int findset( int x) {
        if(p[x]==x) return x;
        return p[x] = findset( p[x]);
    }
     
     
     
    public static void union(int a, int b) {
        a = findset(a);
        b = findset(b);
        if(a<b) p[b] = a;
        else p[a] = b;
         
    }
 
    public static long kruskal() {
        Collections.sort(v,new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
         
        p= new int[V+1];
        for(int i=0; i<V+1; i++) {
            makeSet(i);
        }
         
        long sum = 0;
        for(int i=0; i<v.size(); i++) {
            if(findset(v.get(i)[0])!= findset(v.get(i)[1])) {
                sum += v.get(i)[2];
                union(v.get(i)[0], v.get(i)[1]);
            }
        }
        return sum;
    }
     
 
}

