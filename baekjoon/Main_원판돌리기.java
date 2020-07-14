package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_원판돌리기 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] t = br.readLine().split(" ");
		int N = Integer.parseInt(t[0]);
		int M = Integer.parseInt(t[1]);
		int T = Integer.parseInt(t[2]);
		
		int[][] ia = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				ia[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] ta = new int[T][3];
		for(int i=0;i<T; i++){
			String[] s = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				ta[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		for(int i=0; i<T; i++) {
			int x = ta[i][0];
			int d = ta[i][1];
			int k = ta[i][2];
			for(int j=x-1; j<N; j+=x) {
				for(int l=0; l<k; l++) {
				if(d==0) {
					int temp = ia[j][M-1];
					for(int y=M-1; y>0; y--) {
						ia[j][y] = ia[j][y-1];
					}
					ia[j][0] = temp;
				}
				else {
					int temp = ia[j][0];
					for(int y=0; y<M-1; y++) {
						ia[j][y] = ia[j][y+1];
					}
					ia[j][M-1] = temp;
				}
			}
		}
			
			//for(int[] a: ia) System.out.println(Arrays.toString(a));
			//System.out.println("돌");
			// 돌린 후 작업 
			int bol = 0;
			int count = 0;
			int sum = 0;
			int[][] tempa = new int[N][M];
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(ia[a][b] != 0) count++;
					sum += ia[a][b];
					tempa[a][b] = ia[a][b];
				}
			}
			
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					for(int w=0; w<4; w++) {
						int ni = a+di[w];
						int nj = b+dj[w];
						if(ni < 0) continue;
						if(nj < 0) nj = M-1;
						if(ni > N-1) continue;
						if(nj > M-1) nj = 0;
						
						if(tempa[a][b] != 0 && tempa[a][b] == tempa[ni][nj]) {
							bol = 1;
							ia[a][b]  =  0;
							ia[ni][nj] = 0;
						}
					}
				}
			}
			
			if(bol==0) {
				double avg = (sum*1.0)/(count*1.0);
				for(int a=0; a<N; a++) {
					for(int b=0; b<M; b++) {
						if(ia[a][b] != 0 && ia[a][b] > avg) {
							ia[a][b] -= 1;
						}
						else if(ia[a][b]!=0 && ia[a][b] < avg) {
							ia[a][b] += 1;
						}
					}
				}
			}
			//for(int[] a: ia) System.out.println(Arrays.toString(a));
			//System.out.println("계");
	}
		
		//for(int[] a: ia) System.out.println(Arrays.toString(a));
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				result += ia[i][j];
			}
		}
		
		
		System.out.println(result);
		

	}

}
