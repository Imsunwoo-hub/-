package programmers;

import java.util.*;
class Node{
    int end;
    int cost;
    Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}

class Solution_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        
        ArrayList<Node>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            list[road[i][0]].add(new Node(road[i][1], road[i][2]));
            list[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        int[] d = new int[N+1];
        int[] v = new int[N+1];
        
        for(int i=1; i<=N; i++) d[i] = INF;
        d[1] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
        
        q.offer(new int[]{1,0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(v[curr[0]]==1) continue;
            v[curr[0]] = 1;
            
            for(Node n : list[curr[0]]){
                if(d[n.end] > d[curr[0]] + n.cost){
                    d[n.end] = d[curr[0]] + n.cost;
                    q.offer(new int[]{n.end, d[n.end]});
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(d[i]<=K) answer++;
        }

        return answer;
    }
}