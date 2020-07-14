package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_암호문3 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<String> al = new ArrayList<>();  
			String[] or_a = br.readLine().split(" ");
			int M = Integer.parseInt(br.readLine());
			String[] pw_a = new String[M];
			pw_a = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				al.add(or_a[i]);
			}
			int idx = 0;
			int cnt = 0;
			while(cnt<M) {
				cnt++;
				if(pw_a[idx].equals("I")) {
					int start = Integer.parseInt(pw_a[idx+1]);
					int end = Integer.parseInt(pw_a[idx+2]);
					int jump = Integer.parseInt(pw_a[idx+2]);
					for(int i=0; i<end; i++) {
						al.add(start+i, pw_a[idx+3+i]);
					}
					idx += 3 + jump;
				}
				else if(pw_a[idx].equals("D")) {
					int start = Integer.parseInt(pw_a[idx+1]);
					int c = Integer.parseInt(pw_a[idx+2]);
					for(int i=0; i<c; i++) {
						al.remove(start);
					}
					idx += 3; 
				}
				else if(pw_a[idx].equals("A")) {
					int s = Integer.parseInt(pw_a[idx+1]);
					int jump = Integer.parseInt(pw_a[idx+1]);
					for(int i=0; i<s; i++) {
						al.add(pw_a[idx+2+i]);
					}
					idx += 2+jump;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(al.get(i)+" ");
			}
			System.out.println();
		}

	}

}
