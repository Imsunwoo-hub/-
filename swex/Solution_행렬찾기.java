package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Solution_행렬찾기 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            int n = Integer.parseInt(br.readLine());
            int[][] ia = new int[n][n];
            int[][] v = new int[n][n];
             
            List<int[]> result = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String[] s = br.readLine().split(" "); 
                for(int j=0; j<n; j++) {
                    ia[i][j] = Integer.parseInt(s[j]);
                }
            }
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(ia[i][j]!=0 && v[i][j]==0) {
                        int col = 0;
                        int row = 0;
                        for(int b=j; b<n; b++) {
                            if(ia[i][b]==0) break;
                            v[i][b]=1;
                            row++;
                        }
                        for(int a=i; a<n; a++) {
                            if(ia[a][j]==0) break;
                            v[a][j]=1;
                            col++;
                        }
                        for(int a=i; a<i+col; a++) {
                            for(int b=j; b<j+row; b++) {
                                v[a][b] = 1;
                            }
                        }
                        if(col!=row && (col!=0 && row!=0)) {
                            if(result.size()==0) {
                                result.add(new int[] {col,row});
                            }
                            else {
                                int bol=0;
                                for(int a=0; a<result.size(); a++) {
                                    if(result.get(a)[0]==col || result.get(a)[1]==row) {
                                        bol=1;
                                        break;
                                    }
                                }
                                if(bol==0) {
                                    result.add(new int[] {col,row});
                                }
                            }
                        }
                    }
                }
            }
            Collections.sort(result, new Comparator<int[]>() {
 
                @Override
                public int compare(int[] o1, int[] o2) {
                    int r = Integer.compare(o1[0]*o1[1], o2[0]*o2[1]);
                    if(r==0) r = Integer.compare(o1[0], o2[0]);
                    return r;
                }
            });
            System.out.print("#"+tc+" "+ result.size()+" ");
            for(int[] i:result)System.out.print(i[0]+" "+i[1]+" ");
            System.out.println();
        }
    }
}

