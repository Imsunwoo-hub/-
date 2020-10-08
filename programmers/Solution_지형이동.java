package programmers;

import java.util.*;
public class Solution_지형이동 {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int[] p = new int[land.length*land[0].length];
        for(int i=0; i<land.length*land[0].length; i++) p[i] = i;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
        
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                for(int d = 0; d<4; d++){
                    int ni = i+di[d];
                    int nj = j+dj[d];
                    if(ni>=0 && nj>=0 && ni<land.length && nj<land[i].length){
                        int h = Math.abs(land[i][j]- land[ni][nj]);
                        if(h <= height) q.offer(new int[] {i*land.length+j, ni*land.length+nj ,0});
                        else q.offer(new int[] {i*land.length+j, ni*land.length+nj ,h});
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(find(curr[0],p)==find(curr[1],p)) continue;
            answer += curr[2];
            union(curr[0], curr[1], p);
        }
        return answer;
    }
    
    public void union(int a, int b, int[] p){
        a = find(a,p);
        b = find(b,p);
        if(a<b) p[b] = a;
        else p[a] = b;
    }
    
    public int find(int x, int[] p){
        if(p[x]==x) return x;
        return p[x] = find(p[x], p);
    }
}
