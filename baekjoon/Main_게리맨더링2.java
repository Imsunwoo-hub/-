package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_게리맨더링2 {
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map  = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for(int d1=1; d1<N; d1++) {
			for(int d2=1; d2<N; d2++) {
				for(int x=0; x<N; x++) {
					for(int y=0; y<N; y++ ) {
						if(y-d1 < 0 ||  y+d2>=N || x+d1+d2 >=N) continue;
						int[][] tmap = new int[N][N];
						for(int a=0; a<=d1; a++) {
							for(int b=0; b<=d2; b++) {
								tmap[x+a][y-a] = 5;
								tmap[x+b][y+b] = 5;
								tmap[x+a+b][y-a+b] = 5;
								tmap[x+b+a][y+b-a] = 5;
							}
						}
					
						for(int i=0; i<N; i++) {
							for(int j=0; j<N; j++) {
								if(tmap[i][j]==0) {
									int cnt = 0;
									for(int d=0; d<4; d++) {
										int ni = i+di[d];
										int nj = j+dj[d];
										if(ni>=0 && nj>=0 && ni<N && nj<N && tmap[ni][nj]==5) cnt++;
									}
									if(cnt>=3) {
										dfs(i,j,tmap);
										
									}
								}
							} 
						}
						
						for(int r=0; r<x+d1; r++) {
							for(int c=0; c<=y; c++) {
								if(tmap[r][c]!=0) break;
								tmap[r][c] = 1;
							}
						}
						for(int r=0; r<=x+d2; r++) {
							for(int c=y; c<N; c++)
								if(tmap[r][c]==0) tmap[r][c] = 2;
						}
						for(int r=x+d1; r<N; r++) {
							for(int c=0; c<y-d1+d2; c++) {
								if(tmap[r][c]==0) tmap[r][c] = 3;
							}
						}
						for(int r=x+d2+1; r<N; r++) {
							for(int c=y-d1+d2; c<N; c++) {
								if(tmap[r][c]==0) tmap[r][c] = 4;
							}
						}
						
						
						int[] cnt = new int[5+1];
						for(int i=0; i<N; i++)
							for(int j=0; j<N; j++)
								cnt[tmap[i][j]] += map[i][j];
						Arrays.sort(cnt);
						if(cnt[5]-cnt[1] < result) result = cnt[5]-cnt[1]; 
						
//						for(int[] t:tmap) System.out.println(Arrays.toString(t));
//						System.out.println();
						
					}
				}	
			}
		}
			
		System.out.println(result);

	}
	
	public static void dfs(int i, int j, int[][] tmap) {
		tmap[i][j] = 5;
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<tmap.length && nj<tmap.length  && tmap[ni][nj]==0) {
				dfs(ni,nj,tmap);
			}
		}
	}

}
