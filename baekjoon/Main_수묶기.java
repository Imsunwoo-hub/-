package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main_수묶기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] ia = new int[N];
		
		for(int i=0; i<N; i++) {
			ia[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ia);
		long result = 0;

		for(int i=ia.length-1; i>=0; i--) {
			if(ia[i]<=0) break;
			if(i==0) {
				result += ia[i];
				break;
			}
			if((ia[i]>1 && ia[i-1] > 1)) {
				result += ia[i]*ia[i-1];
				i--;
			}
			else {
				if(ia[i]==1 || ia[i-1]==1) {
					result += ia[i];
					continue;
				}
				else if(ia[i]==0 || ia[i-1]==0) {
					if(ia[i]>0 || ia[i-1]>0) {
						result += ia[i];
						continue;
					}
				}
				else {
					result += ia[i];
					continue;
				}
			}	
		}
		long result2 = 0;
		
		for(int i=0; i<ia.length; i++) {
			if(ia[i]>=0) break;
			if(i==ia.length-1) {
				result2 += ia[i];
				break;
			}
			if(ia[i] <= 0 && ia[i+1] <= 0) {
				result2 += ia[i]*ia[i+1];
				i++;
			}
			
			else {
				result2 +=ia[i];
			}
		}
		
		System.out.println(result+result2);
	}

}
