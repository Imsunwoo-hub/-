package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_듣보잡 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> nlist = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String w = br.readLine();
			nlist.add(w);
		}
		
		Collections.sort(nlist);
		
		for(int i=0; i<M; i++) {
			String w = br.readLine();
			int l = 0;
			int r = nlist.size()-1;
			int bol = 0;
			while(l<=r) {
				int mid = (l+r)/2;
				String temp = nlist.get(mid);
				int x = w.compareTo(temp);
				//System.out.println(temp+" "+w + " "+x);
				if(x==0) {
					bol = 1;
					break;
				}
				else if(x>0) {
					l = mid+1;
				}
				else {
					r = mid-1;
				}
			}
			if(bol == 1) {
				list.add(w);
			}
			
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(String w : list) System.out.println(w);

	}

}
