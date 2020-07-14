package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Solution_미생물격리 {
 
    public static void main(String[] args) throws Exception {
         
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);
            int[][] ia = new int[N][N];
            int[][] map = new int[N][N];
            ArrayList<int[]> list = new ArrayList<>();
             
            for(int i=0; i<K; i++) {
                String[] t= br.readLine().split(" ");
                int[] ka = new int[4];
                for(int j=0; j<4; j++) {
                    ka[j] = Integer.parseInt(t[j]);
                }
                list.add(ka);
                ia[ka[0]][ka[1]] = 1;
            }
            int[] di = {0,-1,1,0,0};
            int[] dj = {0,0,0,-1,1};
            /*
            for(int[] a:ia) System.out.println(Arrays.toString(a));
            System.out.println();*/
             
            while(M>0) {
                 
                M--;
                 
                for(int i=0; i<list.size(); i++) {
                 
                    int x = list.get(i)[0];
                    int y = list.get(i)[1];
                    int c = list.get(i)[2];
                    int w = list.get(i)[3];
                     
                     
                    int ni = x+di[w];
                    int nj = y+dj[w];
                     
                    if(ni==0 || ni==N-1 || nj==0 || nj==N-1) {
                        if (w%2==1) w = w+1;
                        else w = w-1;
                        c = c/2;
                    }
                     
                    if(c==0) {
                        ia[x][y]--;;
                        list.remove(i);
                        i--;
                        continue;
                    }
                     
                    ia[x][y]--;;
                    ia[ni][nj]++;
                    list.set(i, new int[] {ni,nj,c,w});
                     
                }
                 
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<N; j++) {
                            if(ia[i][j] > 1 ) {
                                int idx = -1;
                                int sum = 0;
                                int max = 0;
                                for(int l=0; l<list.size(); l++) {
                                    if(list.get(l)[0]== i && list.get(l)[1]== j) {
                                        sum += list.get(l)[2];
                                        if(list.get(l)[2] > max) {
                                            max = list.get(l)[2];
                                            idx = l;
                                        }
                                    }
                                }
                                list.set(idx, new int[] {i,j, sum, list.get(idx)[3]});
                                ia[i][j] = 1;
                                for(int l=0; l<list.size(); l++) {
                                    if(list.get(l)[0]==i && list.get(l)[1]==j) {
                                        if(list.get(l)[2] != sum) {
                                            list.remove(l);
                                            l--;
                                        }
                                    }
                                }
                            }
                        }
                    }
                     
                    /*for(int[] a:ia) System.out.println(Arrays.toString(a));
                    System.out.println();*/
                     
            }
            int result = 0;
            for(int[] i : list) {
                result += i[2];
            }
             
            System.out.println("#"+tc+" "+result);
        }
 
    }
 
}

