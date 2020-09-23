package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_설탕배달 {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(N > 0){
			if(N % 5 == 0){
				N -=5;
				result++;
			}
			else if(N % 3 ==0){
				N -=3;
				result++;
			}
			else if(N > 5){
				N -=5;
				result++;
			}
			else{
				result = -1;
				break;
			}
			
		}
		
		System.out.println(result);
	}
}
