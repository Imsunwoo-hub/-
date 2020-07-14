package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class arry{
    Set<Integer> list = new HashSet<>();
}

public class Main_ABCDE {



    static int result,N, v[];
    static arry[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        list = new arry[N];
        v = new int[N];

        for(int i=0; i<M; i++){
            String[] t = br.readLine().split(" ");
            int x = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);
            if(list[x]==null) list[x] = new arry();
            if(list[y]==null) list[y] = new arry();
            list[x].list.add(y);
            list[y].list.add(x);
        }

        result = 0;
        for(int i=0; i<N; i++){
            //if(list[i] != null) System.out.println(i + " : "+ list[i].list);
            if(list[i] != null && list[i].list.size()!=0) {
                v[i] = 1;
                dfs(i, 0);
                v[i] = 0;
            }
            if(result == 1) break;
        }

        System.out.println(result);

    }

    static void dfs(int i, int c){
        if(result == 1 ) return;
        if(c==4){
            result = 1;
            return;
        }
        for(int j : list[i].list){
            if(list[j] != null && v[j]==0){
                v[j] =1;
                dfs(j,c+1);
                v[j]=0;
            }
        }
    }
}
