package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_큐빙 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<= T; tc++) {
			
			//흰색은 w, 노란색은 y, 빨간색은 r, 오렌지색은 o, 초록색은 g, 파란색은 b
			char[][][] cube = {{{'w','w','w'},{'w','w','w'},{'w','w','w'}},
					{{'y','y','y'},{'y','y','y'},{'y','y','y'}},
					{{'r','r','r'},{'r','r','r'},{'r','r','r'}},
					{{'o','o','o'},{'o','o','o'},{'o','o','o'}}, 
					{{'g','g','g'},{'g','g','g'},{'g','g','g'}}, 
					{{'b','b','b'},{'b','b','b'},{'b','b','b'}},
					}; 
			
			int N = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				char d = s[i].charAt(0);
				char c = s[i].charAt(1);
				rotate(cube, d, c);
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(cube[0][j][2-i]);
				}
				System.out.println();
			}
		}
	}
	
	public static void rotate(char[][][] cube, char d, char c) {
	    	// 위 0     아래 1         앞 2           뒤 3         좌 4               우 5
	        int bol = c == '+'? 0:1 ;
	        switch (d) {
	        case 'U': alter(0, 4, 2, 5, 3, bol, cube); break;
	        case 'D': alter(1, 3, 5, 2, 4, bol, cube); break;
	        case 'F': alter(2, 0, 4, 1, 5, bol, cube); break;
	        case 'B': alter(3, 5, 1, 4, 0, bol, cube); break;
	        case 'L': alter(4, 2, 0, 3, 1, bol, cube); break;
	        case 'R': alter(5, 1, 3, 0, 2, bol, cube); break;
	        }
	}
	
	public static void alter(int f, int u, int l, int d, int r, int bol, char[][][] cube) {
		char[][] tmp = new char[3][3];
        char[] tmp2 = new char[3];
        
        if (bol==0) {
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    tmp[i][j] = cube[f][2-j][i];
                }
            }
            for (int i=0; i<3; i++)
                tmp2[i] = cube[u][i][0];
            for (int i=0; i<3; i++)
                cube[u][i][0] = cube[l][0][2-i];
            for (int i=0; i<3; i++)
                cube[l][0][2-i] = cube[d][2][i];
            for (int i=0; i<3; i++)
                cube[d][2][i] = cube[r][2-i][2];
            for (int i=0; i<3; i++)
                cube[r][2-i][2] = tmp2[i];
        }
        else {
            for (int i=0; i<3; i++)
                for (int j=0; j<3; j++) {
                    tmp[i][j] = cube[f][j][2-i];
                }
            for (int i=0; i<3; i++)
                tmp2[i] = cube[u][i][0];
            for (int i=0; i<3; i++)
                cube[u][i][0] = cube[r][2-i][2];
            for (int i=0; i<3; i++)
                cube[r][2-i][2] = cube[d][2][i];
            for (int i=0; i<3; i++)
                cube[d][2][i] = cube[l][0][2-i];
            for (int i=0; i<3; i++)
                cube[l][0][2-i] = tmp2[i];
        }
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		cube[f][i][j] = tmp[i][j]; 
        	}
        }
	}
}
