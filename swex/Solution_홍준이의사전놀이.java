package swex;

class UserSolution {
    
    class Node{
        Node[] next;
        int sum;
        Node(){
            next = new Node[26];
            sum = 0;
        }
    }
     
    Node root;
     
    public void init() {    
        root = new Node();  
    }
     
    public void insert(int buffer_size, String buf) {
        Node node = root;
        for(int i=0; i<buffer_size; i++) {
            if(node.next[buf.charAt(i)-'a']==null) node.next[buf.charAt(i)-'a'] = new Node();
            node = node.next[buf.charAt(i)-'a'];
            node.sum++;
        }
    }
     
    public int query(int buffer_size, String buf) {
        Node node = root;
        for(int i=0; i<buffer_size; i++) {
            if(node.next[buf.charAt(i)-'a']==null) return 0;
            node = node.next[buf.charAt(i)-'a'];
        }
        return node.sum;
    }
}


public class Solution_홍준이의사전놀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
