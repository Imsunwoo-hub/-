package programmers;

public class Solution_쿼드압축후갯수세기 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        dfs(0,0,arr.length,arr, answer);
        
        return answer;
    }
    
    public void dfs(int i, int j, int n, int[][] arr, int[] answer){
        if(n==0) return;
        int temp = arr[i][j];
        int bol = 0;
        for(int a=i; a<i+n; a++){
            for(int b=j; b<j+n; b++){
                if(arr[a][b]!=temp){
                    bol = 1;
                    break;
                }
            } if(bol==1) break;
        }
        if(bol==0) {
            answer[temp]++;
            return;
        }
        n = n/2;
        dfs(i,j,n,arr,answer);
        dfs(i+n,j,n,arr,answer);
        dfs(i,j+n,n,arr,answer);
        dfs(i+n,j+n,n,arr,answer);
    }
}