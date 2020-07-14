package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_게리멘더링 {
	
	public static int N, w[], ia[][], result, r[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		r = new int[N];
		w = new int[N];
		ia = new int[N][N];
		
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			w[i] = Integer.parseInt(s[i]);
		}
		
		for(int i=0; i<N; i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<Integer.parseInt(t[0]); j++) {
			
				ia[i][Integer.parseInt(t[j+1])-1] = 1;
				ia[Integer.parseInt(t[j+1])-1][i] = 1;
			}
		}
		
		
		result = Integer.MAX_VALUE;
		powerset(0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	
	}
	
	public static void powerset(int c) {
		if(c==N) {
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(r[i]==0) a.add(i);
				else b.add(i);
			}
			if(a.size()==0 || b.size()==0) return;
			
			ArrayList<Integer> ta = new ArrayList<>();
			ArrayList<Integer> tb = new ArrayList<>();
			if(solve(a.get(0),a,ta) && solve(b.get(0),b,tb)) {
				int suma = 0;
				int sumb = 0;
				for(int i : a) suma += w[i];
				for(int i : b) sumb += w[i];
				int ss = Math.abs(suma-sumb);
				if(result>ss) result = ss;	
			}
			return;
		}
		r[c] = 0;
		powerset(c+1);
		r[c] = 1;
		powerset(c+1);
		
	}
	
	public static boolean solve(int i,ArrayList<Integer> list, ArrayList<Integer> temp) {
		if(!temp.contains(i)) temp.add(i);
		if(list.size()==temp.size()) {
			/*Collections.sort(list);
			Collections.sort(temp);
			int bol = 0; 
			for(int j=0; j<list.size(); j++) {
				if(list.get(j)!=temp.get(j)) {
					bol=1;
					break;
				}*/
				return true;
			//}
			//if(bol==0) return true;
			//return false;
		}
		
		for(int j=0; j<N; j++) {
			if(ia[i][j]==1 && list.contains(j) && !temp.contains(j)) {
				if(solve(j,list,temp)) return true;
			}
		}
		return false;
	}

}
