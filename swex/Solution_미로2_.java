package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_미로2_ {
	
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {-1,0,1,0};
	public static int N = 100;
	public static int[][] ia = new int[100][100];
	public static int result=0;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int tc = 1; tc <=10; tc++)
		{	
			int T = Integer.parseInt(br.readLine());
			int si = 0; 
			int sj = 0;
			String s = "";
			for(int i=0; i<100; i++) {
				s += br.readLine();
			}
			
			for(int i=0; i<s.length(); i++) {
				ia[i/100][i%100] = s.charAt(i) -'0';
				if(ia[i/100][i%100]==2) {
					si = i/100 ;
					sj = i%100;
				}
			}
			
			result = 0;
			dfsr(si,sj);
			System.out.println("#"+T+" " + result);
		}

	}
	
	public static void dfsr(int i, int j) {
		if(ia[i][j]==3) { 
			result =1;
			return;
		}
		ia[i][j] = -1;
		for(int d=0; d<di.length; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && (ia[ni][nj] ==0||ia[ni][nj]==3)) {
				dfsr(ni,nj);
			}
		}	
	}

}
