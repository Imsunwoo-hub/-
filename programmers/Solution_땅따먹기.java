package programmers;

class Solution_땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        int r = land.length;
        int[][] temp = new int[r][4];
        for(int i=0; i<4; i++) {
        	temp[0][i] = land[0][i];
        }
        for(int i=1; i<r; i++) {
        	for(int j=0; j<4; j++) {
        		for(int k=0; k<4; k++) {
        			if(j != k) {
        				temp[i][j] = Math.max(temp[i][j], land[i][j] + temp[i-1][k] );
        			}
        		}
        	}
        }
        for(int i=0; i<4; i++) {
        	answer = Math.max(answer, temp[r-1][i]);
        }
    return answer;
    }
}