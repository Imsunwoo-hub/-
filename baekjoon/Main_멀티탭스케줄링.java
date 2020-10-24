package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_멀티탭스케줄링 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		
		int[] ia = new int[K];
		
		for(int i=0; i<K; i++) ia[i] = Integer.parseInt(s[i]);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int result = 0;
		
		for(int i=0; i<K; i++) {
			if(list.size() < N) {
				if(!list.contains(ia[i])) list.add(ia[i]);
			}
			else {
				if(!list.contains(ia[i])) {
					int idx = 0;
					int max = 0;
					for(int j=0; j<list.size(); j++) {
						int tidx = j;
						int tmax = 0;
						for(int k=i+1; k<K; k++) {
							if(ia[k]==list.get(j)) {
								break;
							}
							tmax = k;							
						}
						if(tmax > max) {
							idx = tidx;
							max = tmax;
						}
					}
					
					list.set(idx, ia[i]);
					result++;
				}
			}
			
		}
		System.out.println(result);
		

	}

}
