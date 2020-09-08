package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main_가운데를말해요 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(maxHeap.size() <= minHeap.size()) maxHeap.offer(-x);
			else minHeap.offer(x);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && -maxHeap.peek()>minHeap.peek()) {
				int max = -maxHeap.poll();
				int min = minHeap.poll();
				maxHeap.offer(-min);
				minHeap.offer(max);
			}
			System.out.print(-maxHeap.peek() + " ");
		}
		

	}

}
