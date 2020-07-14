package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
 
class obj{
     
    int x;
    int y;
    String name;
     
    obj(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
     
}
 
 
public class Solution_종구의딸이름짓기 {
     
    public static char[][] ca;
    public static int N,M;
    public static String result;
    public static int[] di = {1,0};
    public static int[] dj = {0,1};
    public static int[][] v;
     
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T  = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            ca = new char[N][M];
            v = new int[N][M];
            for(int i=0; i<N; i++) {
                String t = br.readLine();
                for(int j=0; j<M; j++) {
                    ca[i][j] = t.charAt(j); 
                }
            }
            result = "";
            bfs();
            System.out.println("#"+tc+" "+ result);
        }
 
    }
     
    public static void bfs() {
        PriorityQueue<obj> q = new PriorityQueue<>(new Comparator<obj>() {
 
            @Override
            public int compare(obj o1, obj o2) {
                 
                return o1.name.compareTo(o2.name);
            }
 
             
        });
     
        q.offer(new obj(0,0,ca[0][0]+""));
        while(!q.isEmpty()) {
            obj o = q.poll();
            int i = o.x;
            int j = o.y;
            String temp = o.name;
            if(i==N-1 && j==M-1) {
                result = temp;
                break;
            }
            if(v[i][j]==0) {
                v[i][j] = 1;
                for(int d=0; d<di.length; d++) {
                    int ni = i+di[d];
                    int nj = j+dj[d];
                    if(ni<N && nj<M ) {
                        q.offer(new obj(ni,nj,temp+(ca[ni][nj]+"")));
                    }
                }
             
            }
        }   
    }
 
}

