package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_괄호추가하기 {
	
	static int n,result, bol;
	static char[] ca;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		ca = new char[n];
		String s = br.readLine();
		
		for(int i=0; i<s.length(); i++) {
			ca[i] = s.charAt(i);
		}
		bol=0;
		result = 0;
		dfs(1, ca[0]-'0', 0, 0);
		
		System.out.println(result);

	}
	
	
	public static void dfs(int idx, int temp, int before, int isbefore) {
		if(idx>=n) {
			if(bol==0) {
				result = temp;
				bol=1;
			}
			else {
				if(result < temp) result = temp;
			}
			return;
		}
		int next = 0;
		if(ca[idx]=='+') {
			next = temp+(ca[idx+1]-'0');
		} else if(ca[idx]=='-') {
			next = temp-(ca[idx+1]-'0');
		} else if(ca[idx]=='*') {
			next = temp*(ca[idx+1]-'0');
		}
		
		dfs(idx+2, next, temp, 0);
		
		if(idx>1 && isbefore==0) {
			int pnext = 0;
			if(ca[idx]=='+') {
				pnext = (ca[idx-1]-'0')+(ca[idx+1]-'0');
			} else if(ca[idx]=='-') {
				pnext = (ca[idx-1]-'0')-(ca[idx+1]-'0');
			} else if(ca[idx]=='*') {
				pnext = (ca[idx-1]-'0')*(ca[idx+1]-'0');
			}
			
			if(ca[idx-2]=='+') {
				dfs(idx+2, pnext+before, 0, 1);
			} else if(ca[idx-2]=='-') {
				dfs(idx+2, before-pnext, 0, 1);
			} else if(ca[idx-2]=='*') {
				dfs(idx+2, pnext*before, 0, 1);
			}
		}
		
	}
	

}

