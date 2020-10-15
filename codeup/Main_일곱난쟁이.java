package codeup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_일곱난쟁이 {
	
	static int bol = 0;
	static int[] ia;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ia = new int[9];
		list = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,0);
		
	}
	
	public static void dfs(int i, int temp) {
		if(bol == 1) return;
		if(temp > 100) return;
		if(list.size()==7 && temp == 100) {
			Collections.sort(list);
			for(int l:list)System.out.println(l);
			bol = 1;
			return;
		}
		if(i>=9) return;
		dfs(i+1, temp);
		list.add(ia[i]);
		dfs(i+1, temp+ia[i]);
		for(int k=0; k<list.size(); k++) {
			if(list.get(k)==ia[i]) {
				list.remove(k);
				break;
			}
		}
	}

}
