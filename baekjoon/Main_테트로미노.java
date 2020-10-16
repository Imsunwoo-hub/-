package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_테트로미노 {
	
	static ArrayList<int[][]> list;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		
		list.add(new int[][] {{1,1,1,1}});
		list.add(new int[][] {{1,1},{1,1}});
		list.add(new int[][] {{1,0},{1,0},{1,1}});
		list.add(new int[][] {{1,0},{1,1},{0,1}});
		list.add(new int[][] {{1,1,1},{0,1,0}});
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[][] ia = new int[N][M];
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int result = 0;
		
		for(int l=0; l<list.size(); l++) {
			int max = 0;
			for(int k=0; k<2; k++) {
				int[][] map = symmetry(list.get(l));
				list.set(l,map);
				for(int d=0; d<4; d++) {
					int[][] temp = rotate(list.get(l));
					//for(int[] t:temp) System.out.println(Arrays.toString(t));
					//System.out.println();
					for(int i=0; i<=N-temp.length; i++) {
						for(int j=0; j<=M-temp[0].length; j++) {
							int sum = 0;
							for(int a=i; a<i+temp.length; a++) {
								for(int b=j; b<j+temp[0].length; b++) {
									if(temp[a-i][b-j] == 1) {
										sum += ia[a][b];
									}
								}
							}
							if(sum > max) max = sum;
						}
					}
					list.set(l,temp);
				}
			}
			if(max > result) result = max;
		}
		
		
		System.out.println(result);
	}
	
	public static int[][] symmetry(int[][] block){
		int[][] nBlock = new int[block.length][block[0].length];
		
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[0].length; j++) {
				nBlock[i][block[0].length-1-j] = block[i][j];
			}
		}
		
		return nBlock;
	}
	
	public static int[][] rotate(int[][] block){
		int[][] nBlock = new int[block[0].length][block.length];
		
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[i].length; j++) {
				nBlock[j][block.length-1-i] = block[i][j];
			}
		}
		
		return nBlock;
	}

}
