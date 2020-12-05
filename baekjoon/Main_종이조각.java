package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_종이조각 {
	
	static int N, M, result;
	static int[][] ia, v;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		ia = new int[N][M];
		v = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				ia[i][j] = t.charAt(j)-'0';
			}
		}
		result = 0;
		dfs(0,0);
		System.out.println(result);
	}
	
	public static void sum() {
		int sum=0;
        for(int i=0;i<N;i++) {
            int temp=0;
            for(int j=0;j<M;j++) {
                if(v[i][j]==1) {
                	temp*=10; 
                	temp+=ia[i][j];
                }else {
                    sum+=temp;
                    temp=0; 
                }
            }
            sum+=temp;
        }
        
       
        for(int i=0; i<M; i++) {
            int temp=0;
            for(int j=0; j<N; j++) {
                if(v[j][i]==0) {
                	temp*=10; 
                	temp+=ia[j][i];
                }else {
                    sum+=temp;
                    temp=0; 
                }
            }
            sum+=temp;
        }
        result = Math.max(result, sum);
	}
	
	public static void dfs(int i, int j) {
		if(i==N) {
			sum();
			return;
		}
		if(j==M) {
			dfs(i+1, 0);
			return;
		}
		v[i][j] = 1;
		dfs(i, j+1);
		v[i][j] = 0;
		dfs(i, j+1);
	}

}
