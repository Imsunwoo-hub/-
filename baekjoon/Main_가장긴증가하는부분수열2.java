package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_가장긴증가하는부분수열2 {
	
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		String[] s = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(s[i]);
		}
		list = new ArrayList<>();
		list.add(ia[0]);
		for(int i=1; i<N; i++) {
			int lb = lowerBound(ia[i]);
			if(lb==list.size()) {
				list.add(ia[i]);
			}
			else {
				if(list.get(lb) > ia[i]) {
					list.set(lb, ia[i]);
				}
			}
		}
		
		System.out.println(list.size());

	}
	
	public static int lowerBound(int n) {
		int l = 0;
		int r = list.size();
		while(l<r) {
			int mid = (l+r)/2;
			if(list.get(mid) < n) l = mid+1;
			else r = mid;
		}
		return r;
	}
	
	

}
