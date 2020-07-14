package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
public class Solution_준환이의양팔저울 {
     
    public static int count,N, ia[], re[], left, right;
    public static List<Integer> list; 
 
    public static void main(String[] args) throws Exception {
    	
    	System.setIn(new FileInputStream("res/input_d4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            N = Integer.parseInt(br.readLine());
            ia = new int[N];
            //re = new int[N];
            String s[] = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                ia[i] = Integer.parseInt(s[i]);
            }
            count = 0;
            for(int i=0; i<(1<<N); i++) {
            	list = new ArrayList<>();
            	int l = 0;
            	int r = 0;
    			for(int j=0; j<N; j++) {
    				if((i &(1<<j)) > 0) {
    					list.add(ia[j]);
    					l += ia[j];
    				}
    				else {
    					list.add(0);
    					r += ia[j];
    				}
    				if(r>l) break;
    			}
    			if(l>=r) perm(0);
            }
            System.out.println("#"+tc+" "+count);
        }
    }
     
	/*
	 * public static void powerset(int c) { if(c==N) { int cnt = 0; for(int i=0;
	 * i<N; i++) { if(re[i]==0) cnt++; } if(cnt == 0) return; else if(cnt==N) { int
	 * a = 1; for(int i=cnt; i>0; i--) { a *= i; } count += a; return; } perm(0);
	 * return; } re[c]=0; powerset(c+1); re[c]=1; powerset(c+1); }
	 */
     
    public static void perm(int c) {
        if(c==list.size()) {
            count++;
            return;
        }
        for(int i=c; i<list.size(); i++) {
            swap(i,c);
            perm(c+1);
            swap(i,c);
        }
    }
     
    public static void swap(int i, int j) {
        if(i==j) return;
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
     
}
