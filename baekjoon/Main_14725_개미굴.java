package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Node{
	Map<String, Node> map;
	
	Node(){
		map = new HashMap<>();
	}
}

public class Main_14725_개미굴 {
	
	static Node root;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		root = new Node();
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			int k = Integer.parseInt(s[0]);
			Node node = root;
			for(int j=1; j<=k; j++) {
				if(!node.map.containsKey(s[j])) {
					node.map.put(s[j], new Node());
					
				}
				node = node.map.get(s[j]);
			}
		}
		
		dfs(root, 0);
		
	}
	
	static void dfs(Node node, int d) {
		ArrayList<String> list = new ArrayList<>();
		for(String key : node.map.keySet()) {
			list.add(key);
		}
		Collections.sort(list);
		for(String key : list) {
			String s = "";
			for(int i=0; i<d; i++) s += "--";
			System.out.println(s+key);
			dfs(node.map.get(key), d+1);
		}
	}

}
