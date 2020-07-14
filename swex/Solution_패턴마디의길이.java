package swex;

import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.text.rtf.RTFEditorKit;

public class Solution_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d2_2007.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			String s = sc.next();
			String temp = "";
			int end = 1;
			int bol = 1;
			while(true) {
				if(end>s.length()/2)
					{
					bol = 0;
					break;
					}
				temp = s.substring(0,end);
				String t = "";
				for(int i=0; i<end; i++) {
					t += s.charAt(i+end);
				}
				
				if(temp.equals(t)) {
					break;
				}
				end++;
				
			}
			if(bol==1) System.out.println("#" + tc+ " "+end);
			else {
				System.out.println("#" + tc+ " "+s.length());
			}
			
			
		}

	}

}
