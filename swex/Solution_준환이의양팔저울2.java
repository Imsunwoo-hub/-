package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public class Solution_준환이의양팔저울2 {
     
    public static int count,N, ia[], re[], left, right;
    public static List<Integer> list; 
 
    public static void main(String[] args) throws Exception {
    	
    	System.setIn(new FileInputStream("res/input_d4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			ia = new int[N];
			re = new int[N];
			String s[] = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				ia[i] = Integer.parseInt(s[i]);
			}
			count = 0;
			powerset(0);
			System.out.println("#"+tc+" "+count);
		}
	}
	
	public static void powerset(int c) {
		if(c==N) {
			if(re[0] == 0) perm(0);
			return;
		}
		re[c]=0;
		powerset(c+1);
		re[c]=1;
		powerset(c+1);	
	}
	
	public static void perm(int c) {
		if(re[0]==1) return;
		if(c==N) {
			left = 0;
			right = 0;
			for(int i=0; i<re.length; i++) {
				if(re[i]==0) {
					left += ia[i];
				}
				else {
					right += ia[i];
				}
				if(right>left) break;
			}
			if(left>=right) count++;
			return;
		}
		for(int i=c; i<N; i++) {
			swap(i,c);
			perm(c+1);
			swap(i,c);
		}
	}
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int temp = ia[i];
		ia[i] = ia[j];
		ia[j] = temp;
	}
	
}
