package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2447_별찍기10 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		char[][] ca = new char[N][N];
		for(int i=0; i<ca.length; i++) Arrays.fill(ca[i], ' ');
		devide(0,0,N,ca);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.append(ca[i][j]);
			}
			bw.append("\n");
		}
		bw.flush();
	}
	
	public static void devide(int i, int j, int n, char[][] ca) {
		
		if(n==1) {
			ca[i][j] = '*';
			return;
		}
		int newn = n/3;
		for(int a=0; a<3; a++) {
			for(int b=0; b<3; b++) {
				if(a==1 && b==1) continue;
				devide(i+(newn*a), j+(newn*b), newn, ca);
			}
		}
		
	
		
	}

}
