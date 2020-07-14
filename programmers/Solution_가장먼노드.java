package programmers;

import java.util.*;
class Solution_가장먼노드 {
   public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        boolean [][] map = new boolean[n+1][n+1];
   
        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
            
        }
    

        Queue<Integer> nodes = new LinkedList<Integer>();
        nodes.add(1);


        while(!nodes.isEmpty()) {
            int i = nodes.poll();

            for (int j = 2; j <= n; j++) {
                if( dist[j] == 0 && map[i][j] ) {
                    dist[j] = dist[i] + 1;
                    nodes.add(j);
                }
            }
        }

        Arrays.sort(dist);
        int i = dist.length-1;
        for( ; i>0; --i) {
            if( dist[i] != dist[i-1] )
                break;
        }

        return dist.length - i;
    }
}