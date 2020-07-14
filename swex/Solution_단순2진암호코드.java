package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_단순2진암호코드 {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            String[] sa = new String[N];
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                sa[i] = s;
            }
            String code = "";
            int i_idx = 0;
            int j_idx = 0;
            exit: for(int i=0; i<N; i++) {
                String s = sa[i];
                for(int j=s.length()-1; j>=55; j--) {
                    if(s.charAt(j) == '1') {
                        i_idx = i;
                        j_idx = j-55;
                        break exit;
                    }
                }
            }
            for(int j=j_idx; j<=j_idx+55; j++) {
                code += sa[i_idx].charAt(j);
            }
            int result = 0;
            int start = 0;
            String[] ia = new String[8];
            String[] code_a = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
            while(start<56) {
                String temp = "";
                for(int i=start; i<start+7; i++) {
                    temp += code.charAt(i);
                }
                 
                ia[start/7] = temp; 
                start+=7;
            }
            int num1 = 0;
            int num2 = 0;
            int last = 0;
            for(int i=0; i<ia.length; i++) {
                for(int j=0; j<code_a.length; j++) {
                if(i==ia.length-1 && ia[i].equals(code_a[j])) {
                    last = j;
                    break;
                }
                else if(i!=ia.length-1 && ia[i].equals(code_a[j])) {
                    if(i%2==0) {
                        num1 += j;
                        break;
                    }
                    else {
                        num2 += j;
                        break;
                    }
                }
            }
        }
            if((num1*3 + num2+ last)%10==0) {
                result = num1+num2+last;
            }
            System.out.println("#"+tc+" "+result);
        }
    }   
}

