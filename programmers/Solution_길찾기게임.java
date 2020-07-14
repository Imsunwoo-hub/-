package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Node{
	
	int num;
	int x;
	int y;
	Node left;
	Node right;
	
	Node(int num, int x, int y){
		this.num = num;
		this.x = x;
		this.y = y;
	}
}


public class Solution_길찾기게임 {
	
	static int idx, prearr[], postarr[];
	static Node[] nlist;
	
	public static int[][] solution(int[][] nodeinfo) {
		
	        int[][] answer = new int[2][nodeinfo.length];
	        
	        nlist = new Node[nodeinfo.length];
	        
	        prearr = new int[nodeinfo.length];
	        postarr = new int[nodeinfo.length];
	        
	        
	        ArrayList<Integer> list= new ArrayList<>();
	        for(int i=0; i<nodeinfo.length; i++) {
	        	nlist[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
	        	if(!list.contains(nlist[i].y)) list.add(nlist[i].y);
	        }
	        
	        Arrays.sort(nlist, new Comparator<Node>() {

				@Override
				public int compare(Node arg0, Node arg1) {
					int r = -Integer.compare(arg0.y, arg1.y);
					if(r==0) r = Integer.compare(arg0.x, arg1.x);
					return r;
				}
			});
	        
	        Node root = nlist[0];
	        for(int i=1; i<nlist.length; i++) {
	        	linkNode(root, nlist[i]);
	        }
	       idx = 0;
	       preorder(root);
	       idx = 0; 
	       postorder(root);
	       
	       for(int i=0; i<nodeinfo.length; i++) {
	    	   answer[0][i] = prearr[i];
	    	   answer[1][i] = postarr[i];
	       }
	       
	       return answer;
	}
	
	public static void preorder(Node r) {
		if( r==null) return;
		prearr[idx++] = r.num;
		preorder(r.left);
		preorder(r.right);
	}
	public static void postorder(Node r) {
		if(r == null) return;
		postorder(r.left);
		postorder(r.right);
		postarr[idx++] = r.num;
	}
	
	public static void linkNode(Node r, Node c) {
		if(r.x > c.x) {
			if(r.left==null) {
				r.left = c;
			}
			else {
				linkNode(r.left, c);
			}
		}
		else {
			if(r.right==null) r.right = c;
			else linkNode(r.right, c);
		}
	}
	
	
	public static void main(String[] args) {
	
	}

}
