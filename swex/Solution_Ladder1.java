package swex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_Ladder1 {
	
	public static int[][] ladder = new int[100][100];

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		for(int tc = 1; tc <= 10; tc++)
		{
			int T = sc.nextInt();
			int start = 0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j]==2) start = j;
				}
			}
			
			int result = go(98, start, 1);
			System.out.println("#" + T + " "+result);
			
		}

	}

	//  way : 1 위  2 좌 3 우 
	private static int go(int i, int j, int way) {
		if(i==0) return j;
		if(way==1) {
			if( j-1>=0 && ladder[i][j-1]==1 ) return go(i,j-1,2);
			else if(j+1<100 && ladder[i][j+1]==1  ) return go(i,j+1,3);
			else return go(i-1,j,1); 
		}
		else if(way==2) {
			if(ladder[i-1][j]==1) return go(i-1, j, 1);
			else return go(i,j-1,2);
		}
		else {
			if(ladder[i-1][j]==1) return go(i-1,j,1);
			else return go(i,j+1,3);
		}
	}
	
	

}
