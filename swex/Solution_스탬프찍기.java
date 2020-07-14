package swex;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution_스탬프찍기
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);
		
		
	
		for(int tc = 1; tc <= 10; tc++)
		{	
			int N = sc.nextInt();
			
			int[] ia = new int[100];
			for(int i=0; i<ia.length; i++) {
				ia[i] = sc.nextInt();
			}
			
		
			System.out.print("#");
		}
	}
}