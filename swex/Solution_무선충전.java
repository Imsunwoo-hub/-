package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Solution_무선충전 {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] s = br.readLine().split(" ");
            int time = Integer.parseInt(s[0]);
            int bc = Integer.parseInt(s[1]);
             
            int[] A = new int[time+1];
            int[] B = new int[time+1];
            int[][] bc_info = new int[bc][4];
            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");
            for(int i=1; i<time+1; i++) {
                A[i] = Integer.parseInt(a[i-1]);
                B[i] = Integer.parseInt(b[i-1]);
            }
            /*System.out.println(Arrays.toString(A));
            System.out.println(Arrays.toString(B));*/
             
            for(int i = 0; i<bc; i++) {
                String[] t = br.readLine().split(" ");
                for(int j =0; j<4; j++) {
                    bc_info[i][j] = Integer.parseInt(t[j]);
                }
            }
            int total_a = 0;
            int total_b = 0;
            int[] di = {0,0,1,0,-1};
            int[] dj = {0,-1,0,1,0};
             
            int[] aij = {0,0};
            int[] bij = {9,9};
             
            ArrayList<Integer> alist = new ArrayList<>();
            ArrayList<Integer> blist = new ArrayList<>();
             
             
            for(int i=0; i<A.length; i++) {
                 
                aij[0] += di[A[i]];
                aij[1] += dj[A[i]];
                bij[0] += di[B[i]];
                bij[1] += dj[B[i]];
                alist.clear();
                blist.clear();
                 
                for(int j=0; j<bc_info.length; j++) {
                     
                    int C = bc_info[j][2];
                     
                     
                    int x = bc_info[j][0]-1;
                    int y = bc_info[j][1]-1;
                     
                 
                    /*System.out.println(Arrays.toString(aij));
                    System.out.println(Arrays.toString(bij));*/
                     
                    int tempai = Math.abs(aij[0]-x);
                    int tempaj = Math.abs(aij[1]-y);
                    int tempbi = Math.abs(bij[0]-x);
                    int tempbj = Math.abs(bij[1]-y);
                     
                    if(tempai+tempaj <= C && tempbi+tempbj <=C ) {
                        alist.add(j);
                        blist.add(j);
                    }
                    else if(tempai+tempaj <= C) {
                        alist.add(j);
                    }
                    else if(tempbi+tempbj <= C) {
                        blist.add(j);
                    }
                     
                }
                int amax = 0; 
                int aidx = -1;
                int bmax = 0;
                int bidx = -1;
                 
                if(alist.size()!=0) {
                    for(int n : alist) {
                        if(bc_info[n][3] > amax) {
                            amax = bc_info[n][3];
                            aidx = n;
                        }
                    }
                }
                 
                if(blist.size()!=0) {
                    for(int n : blist) {
                        if(bc_info[n][3] > bmax) {
                            bmax = bc_info[n][3];
                            bidx = n;
                        }
                    }
                }
                 
                if(aidx!= -1 && bidx!=-1 && bidx == aidx) {
                    int ta = 0;
                    int tb = 0;
                    for(int n : alist) {
                        if(n != aidx && bc_info[n][3] > ta) {
                            ta = bc_info[n][3];
                        }
                    }
                    for(int n : blist) {
                        if(n != bidx && bc_info[n][3] > tb) {
                            tb = bc_info[n][3];
                        }
                    }
                      
                    if(amax + tb > amax/2+bmax/2) {
                        if(amax +tb > bmax + ta) {
                            total_a += amax;
                            total_b += tb;
                        }
                        else {
                            total_a += ta;
                            total_b += bmax;
                        }
                    }
                    else {
                        if(bmax + ta > amax/2+bmax/2) {
                            total_a += ta;
                            total_b += bmax;
                        }
                        else {
                            total_a += amax/2;
                            total_b += bmax/2;
                        }
                             
                    }
                     
                     
                }
                else {
                    total_a += amax;
                    total_b += bmax;
                }
                 
                /*System.out.println(amax + " " + bmax);*/
                 
            }
             
            int result = total_a + total_b;
            System.out.println("#"+tc+" "+result);
        }
 
    }
 
}
