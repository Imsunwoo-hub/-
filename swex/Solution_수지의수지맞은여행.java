package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class Solution_수지의수지맞은여행 {
    // 우 하 좌 상 
    public static int[] di = {0,1,0,-1};
    public static int[] dj = {1,0,-1,0};
    public static int R,C, max;
    public static String[][] sa;
    public static List<String> list;
     
 
    public static void main(String[] args) throws Exception{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] st = br.readLine().split(" ");
            R = Integer.parseInt(st[0]);
            C = Integer.parseInt(st[1]);
            sa = new String[R][C];
            list= new ArrayList<>();
            for(int i=0; i<R; i++) {
                String[] t = br.readLine().split("");
                for(int j=0; j<C; j++) {
                    sa[i][j] = t[j];
                }
            }
            max= 0;
            dfs(0,0);
             
            System.out.println("#"+tc+" "+max);
        }
    }
     
    public static void dfs(int i, int j) {
        String s = sa[i][j];
        list.add(s);
        if(list.size()>=26)
            return;
         
        for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && ni<R && nj>=0 && nj<C && !list.contains(sa[ni][nj])) {
                dfs(ni,nj);
            }
        }
        if (list.size() > max) {
            max = list.size();
        }
        list.remove(s);
    }
}

