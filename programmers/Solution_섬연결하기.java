package programmers;

import java.util.*;

class Solution_섬연결하기 {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] ia = new int[3];
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = i;
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[2], o2[2]);
				}
			});
        
        for(int i=0; i<costs.length; i++){
            int[] temp = new int[3];
            for(int j = 0; j<3; j++){
                temp[j] = costs[i][j];
            }
            q.offer(temp);
        }
        
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            if(find(curr[0],p) == find(curr[1],p)) continue;
            union(curr[0], curr[1], p);
            answer+= curr[2];
            
        }
        
        return answer;
    }
    
    public void union(int a, int b, int[] p){
        int x = find(a,p);
        int y = find(b,p);
        if(x>y) p[y] = p[x];
        else p[x] = p[y];
    }
    public int find(int x , int[] p){
        if(p[x]==x) return x;
        return p[x] = find(p[x], p);
    }
}