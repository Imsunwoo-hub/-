package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
 
public class Solution_줄기세포배양 {
 
    public static void main(String[] args) throws Exception {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);
             
            int[][] ia = new int[N+K*2][M+K*2];
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                String[] t = br.readLine().split(" ");
                for(int j=0; j<M; j++) {
                    ia[i+K][j+K] = Integer.parseInt(t[j]);
                    if(ia[i+K][j+K]!=0) list.add(new int[] {i+K,j+K,ia[i+K][j+K],0});
                }
            }
            int[] di = {-1,1,0,0}; 
            int[] dj = {0,0,-1,1}; 
            int time = 0;
            //for(int[] a : ia) System.out.println(Arrays.toString(a));
            while(time<K) {
                Collections.sort(list, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                         
                        return -Integer.compare(o1[2], o2[2]);
                    }
                });
                time++;
                ArrayList<int[]> temp = new ArrayList<>();
                //System.out.println(list.size());
                for(int i=0; i<list.size(); i++) {
                    int x = list.get(i)[0];
                    int y = list.get(i)[1];
                    int X = list.get(i)[2];
                    int state = list.get(i)[3];
                    if(X>state) {
                        list.set(i, new int[] {x,y,X, state+1});
                        continue;
                    }
                    else if(X==state) {
                        for(int d=0; d<di.length; d++) {
                            int ni = x + di[d];
                            int nj = y + dj[d];
                            if(ia[ni][nj] == 0) {
                                ia[ni][nj] = X;
                                temp.add(new int[] {ni, nj, X, 0});
                            }
                        }
                        list.set(i, new int[] {x,y,X, state+1});
                        if(state+1 == X*2) {
                            ia[x][y] = -1;
                            list.remove(i);
                            i--;
                            continue;
                        }
                         
                    }
                    else {
                        list.set(i, new int[] {x,y,X, state+1});
                        if(state+1 == X*2) {
                            ia[x][y] = -1;
                            list.remove(i);
                            i--;
                            continue;
                        }
                    }
                }
                for(int[] a : temp) list.add(a);
             
            }
            /*for(int[] a : ia) System.out.println(Arrays.toString(a));
            System.out.println();*/
            int count = 0;
            for(int i=0; i<N+K*2; i++) {
                for(int j=0; j<M+K*2; j++) {
                    if(ia[i][j]>0) {
                        count+=1;
                    }
                }
            }
            System.out.println("#"+tc+" "+count);
        }       
         
    }
     
 
}

