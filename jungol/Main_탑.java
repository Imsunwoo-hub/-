package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main_탑 {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
         
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();*/
         
        int[] ia = new int[N];
        int[] result = new int[N];
         
        String line= br.readLine();
        String[] s = line.split(" ");
         
        for(int i=0; i<s.length; i++) {
            ia[i] = Integer.parseInt(s[i]);
        }
         
        for(int i=ia.length-1; i>=0; i--) {
            int temp = ia[i];
            for(int j=i-1; j>=0; j--) {
                if(ia[j]>temp) {
                    result[i]=j+1;
                    break;
                }
            }
             
        }
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i]+ " ");
        }
    }
 
}

