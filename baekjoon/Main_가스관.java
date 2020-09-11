package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_가스관 {
	
	static int N,M, r, c, cnt;
	static char result, map[][];
	static char[] block = {'|','-','+','1','2','3','4'};
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[] end;
	static int[] addBlock, v[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		map = new char[N][M];
		v = new int[N][M];
		int[] start = new int[2];
		end = new int[2];
		addBlock = new int[2];
		
		for(int i=0; i<N; i++) {
			String t = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j]=='M') {
					start[0] = i;
					start[1] = j;
				}
				if(map[i][j] == 'Z') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		
		result = '0';
		dfs(start[0],start[1],-1, new int[] {-1,-1},'0',0,0);
		System.out.println((addBlock[0]+1) + " " + (addBlock[1]+1) +" "+ result);
	}
	
	public static void dfs(int i, int j, int before, int[] add, char temp, int c, int r) {
		
		v[i][j]++;
		
		if(map[i][j]=='Z') {
			int bol = 0;
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if((map[a][b]!='.' && map[a][b]!='M' &&  map[a][b]!='Z') && v[a][b]==0) {
						bol = 1;
						break;
					}
				}
			}
			if(temp=='+') {
				if(add[0]-1>=0 && add[0]+1 <N && map[add[0]-1][add[1]]== 'M' && map[add[0]+1][add[1]]=='Z') {
					v[i][j]--;
					return;
				}
				if(add[0]-1>=0 && add[0]+1 <N &&map[add[0]-1][add[1]]== 'Z' && map[add[0]+1][add[1]]=='M') {
					v[i][j]--;
					return;
				}
				if(add[1]-1>=0 && add[1]+1 <M &&map[add[0]][add[1]-1] =='M' && map[add[0]][add[1]+1]=='Z') {
					v[i][j]--;
					return;
				}
				if(add[1]-1>=0 && add[1]+1 <M &&map[add[0]][add[1]-1] =='Z' && map[add[0]][add[1]+1]=='M') {
					v[i][j]--;
					return;
				}
			}
			
			if(bol==0) {
				addBlock[0] = add[0];
				addBlock[1] = add[1];
				result = temp;
			}
			v[i][j] = 0;
			return;
		}
		if(map[i][j]=='.') {
			if(c==1) {
				v[i][j]--;
				return;
			}
			for(int k=0; k<block.length; k++) {
				if(block[k]=='+') {
					if(!check(i,j))continue;
				}
				map[i][j] = block[k];
				dfs(i,j,before,new int[] {i,j}, block[k],c+1,r);
				map[i][j] = '.';
			}
		}
		if(map[i][j]=='M') {
			if(r>0) {
				v[i][j]--;
				return;
			}
			for(int d=0; d<4; d++) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<M) {
					dfs(ni,nj,d,add,temp,c,r);
				}
				
			}
		}
		if(map[i][j]=='|') {
			if(before==0 || before==1) {
			int ni = i+di[before];
			int nj = j+dj[before];
			if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,before,add,temp,c,r+1);
			}
		}
		if(map[i][j]=='-') {
			if(before ==2 || before==3) {
				int ni = i+di[before];
				int nj = j+dj[before];
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,before,add,temp,c,r+1);
			}
		}
		if(map[i][j]=='+') {
			int ni = i+di[before];
			int nj = j+dj[before];
			if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,before,add,temp,c,r+1);
		}
		if(map[i][j]=='1') {
			
			int ni = i;
			int nj = j;
			if(before==0) {
				nj++;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,3,add,temp,c,r+1);
			}
			else if(before==2) {
				ni++;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,1,add,temp,c,r+1);
			}
		}
		if(map[i][j]=='2') {
			
			int ni = i;
			int nj = j;
			if(before==1) {
				nj++;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,3,add,temp,c,r+1);
			}
			else if(before==2) {
				ni--;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,0,add,temp,c,r+1);
			}
			
		}
		if(map[i][j]=='3') {
			
			int ni = i;
			int nj = j;
			if(before==3) {
				ni--;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,0,add,temp,c,r+1);
			}
			else if(before==1) {
				nj--;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,2,add,temp,c,r+1);
			}
		}
		if(map[i][j]=='4') {
			int ni = i;
			int nj = j;
			if(before==3) {
				ni++;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,1,add,temp,c,r+1);
			}
			else if(before==0) {
				nj--;
				if(ni>=0 && nj>=0 && ni<N && nj<M) dfs(ni,nj,2,add,temp,c,r+1);
			}
		}
		v[i][j]--;
	}
	
	public static boolean check(int i, int j) {
		if(i-1 < 0 ||map[i-1][j]=='-' ||map[i-1][j]=='.' || map[i-1][j]=='2' || map[i-1][j]=='3') return false;
		if(i+1 >= N ||map[i+1][j]=='-' || map[i+1][j]=='.' || map[i+1][j]=='1' || map[i+1][j]=='4') return false;
		if(j-1 <0 || map[i][j-1]=='|' ||map[i][j-1] =='.' || map[i][j-1] =='3' || map[i][j-1] =='4') return false;
		if(j+1 >=M || map[i][j+1]=='|' ||map[i][j+1]=='.' || map[i][j+1]=='1' || map[i][j+1]=='2') return false;
		
		return true;
	}
}
