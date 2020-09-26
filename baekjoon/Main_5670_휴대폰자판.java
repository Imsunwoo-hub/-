package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Trie{
	int cnt;
	Trie[] list;
	Trie(){
		list = new Trie[26];
		cnt = 0;
	}
}

public class Main_5670_휴대폰자판 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			try {
				Trie root = new Trie();
				
				int N = Integer.parseInt(br.readLine());
				
				String[] s = new String[N];
				
				for(int i=0; i<N; i++) {
					String t = br.readLine();
					s[i] = t;
					Trie node = root;
					for(int j=0; j<t.length(); j++) {
						if(node.list[t.charAt(j)-97] == null) {
							node.list[t.charAt(j)-97] = new Trie();
						}
						node = node.list[t.charAt(j)-97];
						node.cnt++;
					}
				}
				int result = 0;
				for(int i=0; i<N; i++) {
					String word = s[i];
					Trie node = root;
					int count = 0;
					for(int j=0; j<word.length(); j++) {
						int idx = word.charAt(j)-97;
						int bol = 0;
						int nextidx = 0;
						for(int k=0; k<26; k++) {
							if(node.list[k]!=null) {
								nextidx = k;
								bol++;
							}
						}
						
						if(j == 0 || bol!=1) {
							count++;
						}
						else {
							if(node.list[nextidx].cnt != node.cnt) count++;
						}
						node = node.list[idx];
					}
				
					result += count;
				}
				bw.append(String.format("%.2f", (double)result/N)+"\n");
				
			}
			catch(Exception e) {
				break;
			}
		}
		bw.flush();
	}

}
