package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
 
public class Main_스도쿠 {
     
    public static int[][] ia, v;
    public static int[] num;
    public static int[] di = {-1,1,0,0};
    public static int[] dj = {0,0,-1,1};
    static ArrayList<int[]> list;
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ia = new int[9][9];
        v  = new int[9][9];
        num = new int[10];
        int c = 0;
        Arrays.fill(num, 9);
        list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            String[] s = br.readLine().split(" ");
            for(int j=0; j<9; j++) {
                ia[i][j] = Integer.parseInt(s[j]);
                num[ia[i][j]]--;
                if(ia[i][j]==0) {
                    c++;
                    list.add(new int[] {i,j});
                }
            }
        }
        num[0] = c;
        v[0][0] = 1;
        dfs(0);
    }
 
    public static void dfs(int i) {
         
        if(num[0]==0) {
            for(int x =0; x<9; x++) {
                for(int y =0; y<9; y++) {
                    System.out.print(ia[x][y]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }   
         
        for(int k=1; k<10; k++) {
            if(num[k]!=0) {
                //System.out.println(solve(i,j,k));
                if(solve(list.get(i)[0], list.get(i)[1], k)) {
                    ia[list.get(i)[0]][list.get(i)[1]] = k;
                    num[0]--;
                    num[k]--;
                    //System.out.println(num[0]);
                    dfs(i+1);
                    ia[list.get(i)[0]][list.get(i)[1]] = 0;
                    num[0]++;
                    num[k]++;
                }
            }
        }
         
         
        /*for(int d=0; d<di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(ni>=0 && nj>=0 && ni<9 && nj<9 && v[ni][nj]==0) {
                 
                if(ia[i][j]==0) {
                     
                }
                else {
                    v[ni][nj] = 1;
                    dfs(ni,nj);
                    v[ni][nj] = 0;
                    }
            }
        }*/
         
         
    }
     
     
     
     
     
     
     
     
     
     
     
    public static boolean solve(int i, int j , int n) {
         
        //System.out.println("solve");
        for(int x=0; x<9; x++) {
            if(ia[x][j
                     ] == n) return false; 
        }
         
        for(int y=0; y<9; y++) {
            if(ia[i][y]==n) return false;
        }
         
        int xs = (i/3)*3;
        int ys = (j/3)*3;
         
        for(int x=xs; x<xs+3; x++) {
            for(int y=ys; y<ys+3; y++) {
                if(ia[x][y] ==n) return false;
            }
        }
         
        return true;
    }
}

