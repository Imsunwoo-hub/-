package swex;

import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution_홀수피라미드
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
         
            
            long r1=0, r2=0;
            
            long c=  N-1;
            if(c==0){
                r1=1;
                r2 =1;
            } else{
                r1 = (N*c-c)*2+1;
                r2 = (N*c+c)*2+1;
            }
            System.out.println("#"+test_case+" "+r1+" "+r2);
        }
    }
}

