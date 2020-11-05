package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_통나무건너뛰기 {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] ia = new int[N];
			String[] s = br.readLine().split(" ");
			
			for(int i=0; i<N; i++) ia[i] = Integer.parseInt(s[i]);
			
			Arrays.sort(ia);
			int[] resultSet = new int[N];
			resultSet[0] = ia[0];
			resultSet[N-1] = ia[1];
			resultSet[N/2] = ia[N-1];
			int idx = 2;  
			int bol = 0;
			int l = 1;
			int r = N-2;
			while(idx < N-1) {
				
				if(bol==0) {
					resultSet[l++] = ia[idx++];
					bol =1;
				}else {
					resultSet[r--] = ia[idx++];
					bol = 0;
				}
				
			}
			
			
			int result = 0;
		
			for(int i=0; i<N; i++) {
				if(i==N-1) {
					int temp = Math.abs(resultSet[i]-resultSet[0]);
					if(temp > result) result = temp;
				}
				else {
					int temp = Math.abs(resultSet[i]-resultSet[i+1]);
					if(temp > result) result = temp;
				}
			}
			
			
			
			bw.append(result+"\n");
			
		}
		bw.flush();
	}	

}
