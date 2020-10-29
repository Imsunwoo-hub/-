package programmers;

public class Solution_지형편집 {
    public long solution(int[][] land, int P, int Q) {
        long answer = 0;
        int n = land.length;
        long l = Integer.MAX_VALUE;
        long r = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if( l > land[i][j] ) l = land[i][j];
                if( r < land[i][j] ) r = land[i][j]; 
            }
        }
        
        while(l<=r){
            long mid = (l+r)/2;
            if(l==r){
                answer = mid;
                break;
            }
            
            long a = solve(mid, land, P,Q);
            long b = solve(mid+1, land, P,Q);
            
            if(a==b){
                answer = mid;
                break;
            }
            else if(a < b){
                r = mid;
            }
            else {
                l = mid+1;
            }
            
        }
        return solve(answer,land,P,Q);
    }
    
    public long solve(long v, int[][] land, int P, int Q){
        long result = 0;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land.length; j++){
                if(land[i][j] < v) result = result + (v-land[i][j])*P;
                else result = result + (land[i][j]-v)*Q;
            }
        }
        return result;
    }
}
