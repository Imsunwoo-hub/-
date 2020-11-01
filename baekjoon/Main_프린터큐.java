package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_프린터큐 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int idx = Integer.parseInt(s[1]);
			
			Queue<int[]> q = new LinkedList<>();
			s = br.readLine().split(" ");
			int[] ia = new int[N];
			for(int i=0; i<N; i++) {
				q.offer(new int[] {i, Integer.parseInt(s[i])});
				ia[i] = Integer.parseInt(s[i]);
			}
			int result = 0;
			int now = ia.length-1;
			Arrays.sort(ia);
			while(!q.isEmpty()) {
				
				int[] curr = q.poll();
				
				if(curr[1]<ia[now]) {
					q.offer(curr);
				}
				else {
					if(curr[0]==idx) {
						result++;
						break;
					}
					else {
						result++;
						now--;
					}
				}
					
			}
			
			bw.append(result + "\n");
		}
		
		bw.flush();
	}

}
