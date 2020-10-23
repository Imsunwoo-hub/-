package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main_한줄로서기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[][] ia = new int[N][2];
		
		for(int i=0; i<N; i++) {
			ia[i][0] = i+1;
			ia[i][1] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(ia, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int r = Integer.compare(o1[1], o2[1]);
				if(r==0) r = Integer.compare(o1[0], o2[0]);
				return r;
			}
		});
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int[] i:ia) {
			int cnt = 0;
			int seq = i[1];
			if(seq == 0) {
				list.add(i);
				continue;
			}
			for(int j=0; j<list.size(); j++) {
				if(list.get(j)[0] > i[0]) cnt++;
				if(cnt==seq && j==list.size()-1) {
					list.add(i);
					break;
				}
				if(cnt > seq) {
					list.add(j,i);					
					break;
				}
				
			}
		}
		for(int[] l:list) System.out.print(l[0]+" ");
	}
}
