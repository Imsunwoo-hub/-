package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_분산처리 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] computer = new int[10];
		for(int i=1; i<10; i++ ) computer[i] = i;
		computer[0] = 10; 
		
		int[][] data = {{0,0,0,0},{1,1,1,1},{2,4,8,6},{3,9,7,1},{4,6,4,6},{5,5,5,5},{6,6,6,6},{7,9,3,1},{8,4,2,6},{9,1,9,1}};
 		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			
			int a = s[0].charAt(s[0].length()-1)-'0';
			int b = Integer.parseInt(s[1]);
			int n = b%4-1;
			if(n<0) n = 3;
			bw.append(computer[data[a][n]]+"\n");
		}
		bw.flush();
	}

}
