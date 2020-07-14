package swex;

import java.util.Scanner;

public class Solution_간단한369게임 {

	public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bol=0;
        String c="";
        String s="";
        for(int i=1; i<=N; i++) {
            s = String.valueOf(i);
            bol = 0;
            c="";
            for(int j=0; j<s.length(); j++) {
                  
                if(s.charAt(j)=='3' || s.charAt(j)=='6' ||s.charAt(j)=='9') {
                    bol=1;
                    c+='-';
                }
            }
            if(bol==1) System.out.print(c+" ");
            else System.out.print(i+" ");
        }
    }
}

