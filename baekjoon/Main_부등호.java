package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_부등호 {
	
	static int N;
	static ArrayList<String> result;
	static int[] v;
	static String[] s;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		s = br.readLine().split(" ");
		
		v = new int[10];
		result = new ArrayList<>();
		
		dfs(0,"");
		
		Collections.sort(result);
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));

	}
	public static void dfs(int i, String temp) {
		if(temp.length()==N+1) {
			int bol = 0;
			for(int j=0; j<N; j++) {
				if(s[j].equals("<")) {
					if(temp.charAt(j)-'0' > temp.charAt(j+1)-'0') {
						bol = 1;
						break;
					}
				} else {
					if(temp.charAt(j)-'0' < temp.charAt(j+1)-'0') {
						bol = 1;
						break;
					}
				}
			}
			if(bol==0) result.add(temp);
			
			return;
		}
		
		for(int j=0; j<=9; j++) {
			if(v[j]==0) {
				v[j] = 1;
				dfs(i+1, temp+j);
				v[j] = 0;
			}
		}
	}
}
