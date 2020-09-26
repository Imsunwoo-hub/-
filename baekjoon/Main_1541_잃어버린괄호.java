package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		String t = "";
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='+' || s.charAt(i)=='-') {
				list.add(t);
				list.add(s.charAt(i)+"");
				t = "";
			}
			else t += s.charAt(i); 
			if(i==s.length()-1) list.add(t);
		}
		
		
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("+")) {
				int temp = Integer.parseInt(list.get(i-1)) + Integer.parseInt(list.get(i+1));
				list.set(i, temp+"");
				list.remove(i-1);
				list.remove(i);
				i--;
			}
		}
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals("-")) {
				int temp = Integer.parseInt(list.get(i-1)) - Integer.parseInt(list.get(i+1));
				list.set(i, temp+"");
				list.remove(i-1);
				list.remove(i);
				i--;
			}
		}
			
		int result = Integer.parseInt(list.get(0));
		
		System.out.println(result);
	}

}
