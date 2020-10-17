package beakjoon;


import java.util.ArrayList;
import java.util.Scanner;

public class Main_테트리스게임 {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<int[][]> list = new ArrayList<>();
		
		list.add(new int[][] {{1,1,1,1}});
		list.add(new int[][] {{1,1},{1,1}});
		list.add(new int[][] {{1,1,0},{0,1,1}});
		list.add(new int[][] {{1,1,1},{0,0,1}});
		list.add(new int[][] {{1,1,1},{0,1,0}});
		int tc = 1;
		while(true) {
			int N = sc.nextInt();
			if(N==0) break;
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = Integer.MIN_VALUE;
			for(int l=0; l<list.size(); l++) {
				for(int d=0; d<4; d++) {
					int[][] temp = rotate(list.get(l));
					
					for(int i=0; i<=N-temp.length; i++) {
						for(int j=0; j<=N-temp[0].length; j++) {
							int sum = 0;
							for(int a=i; a<i+temp.length; a++) {
								for(int b=j; b<j+temp[0].length; b++) {
									if(temp[a-i][b-j]==1) {
										sum += map[a][b];
									}
								}
							}
							if(sum > result) result = sum;
						}
					}
					
					
					list.set(l, temp);
				}
				
			}
			
			System.out.println(tc+". "+ result);
			tc++;
		}
		sc.close();
	}
	
	public static int[][] rotate(int[][] block){
		int[][] nBlock = new int[block[0].length][block.length];
		
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[0].length; j++) {
				nBlock[j][block.length-1-i] = block[i][j];
			}
		}
		
		return nBlock;
	}
}
