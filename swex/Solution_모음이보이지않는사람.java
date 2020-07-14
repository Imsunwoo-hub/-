package swex;

 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.BrokenBarrierException;
 
public class Solution_모음이보이지않는사람 {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            String s = br.readLine();
            String result = "";
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)!='a' && s.charAt(i)!='e' && s.charAt(i)!='i' && s.charAt(i)!='o' && s.charAt(i)!='u' ) {
                    result += s.charAt(i);
                }
            }
            System.out.println("#"+tc+" "+ result);
        }
         
    }
 
}
 