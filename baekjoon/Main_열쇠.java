package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_열쇠 {
	
	static int result, h,w, key[];
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static char[][] map, tmap;
	static int[][] v;
	static ArrayList<int[]>[] door;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			String[] s = br.readLine().split(" ");
			h = Integer.parseInt(s[0]);
			w = Integer.parseInt(s[1]);
			
			map = new char[h+2][w+2];
			v = new int[h+2][w+2];
	
			 for(int i=0; i<h+2; i++) {
	                for(int j=0; j<w+2; j++) {
	                    map[i][j]='.';
	                }
	            }
			
			
			for(int i=1; i<=h; i++) {
				String t = br.readLine();
				for(int j=1; j<=w; j++) {
					map[i][j] = t.charAt(j-1);
				}
			}
			
			String keys = br.readLine();
			key = new int[26];
			door = new ArrayList[26];
			for(int i=0; i<26; i++) {
				door[i] = new ArrayList<int[]>();
			}
			if(!keys.equals("0")) {
				for(int i=0; i<keys.length(); i++) {
					int k = keys.charAt(i)-'a';
					key[k] = 1;
				}
			}
			result = 0;
			bfs();	
			System.out.println(result);
		}

	}
	
	public static void bfs() {
	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[] {0,0});
	        v[0][0] = 1;
	        
	        while(!q.isEmpty()) {
	            int[] a = q.poll();
	            
	            for(int d=0; d<4; d++) {
	                int ni = a[0]+di[d];
	                int nj = a[1]+dj[d];
	                if(ni>=0 && nj>=0 && ni<h+2 && nj<w+2) {
	                    if(v[ni][nj]==0 && map[ni][nj]!='*') {
	                    	
	                        if(map[ni][nj]-'A'>=0 && map[ni][nj]-'A'<=25) {   
	                            if(key[map[ni][nj]-'A']==1) {   
	                                map[ni][nj]='.';    
	                                q.add(new int[] {ni,nj});
	                                v[ni][nj]=1;
	                            }
	                            else {
	                                door[map[ni][nj]-'A'].add(new int[] {ni,nj});
	                            }
	                        }
	                        else if(map[ni][nj]-'a'>=0 && map[ni][nj]-'a'<=25) {  
	                            key[map[ni][nj]-'a'] = 1;
	                            v[ni][nj] = 1;
	                            q.add(new int[] {ni,nj});
	                        }
	                        else if(map[ni][nj] == '.') {  
	                            v[ni][nj] = 1;    
	                            q.add(new int[] {ni,nj});
	                        }
	                        else if(map[ni][nj]=='$') {    
	                            result++;
	                            v[ni][nj] = 1;
	                            q.add(new int[] {ni,nj});
	                        }
	                        
	                        for(int j=0; j<=25; j++) {
	                            if(door[j].size()!=0 && key[j]==1) {
	                                for(int k=0; k<door[j].size(); k++) {
	                                    int[] tmp= door[j].get(k);
	                                    map[tmp[0]][tmp[1]] ='.';
	                                    v[tmp[0]][tmp[1]] = 1;
	                                    q.add(new int[] {tmp[0],tmp[1]});
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
}

