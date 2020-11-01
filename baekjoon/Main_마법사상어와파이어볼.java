package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_마법사상어와파이어볼 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		
		int[][] mmap = new int[N][N]; 
		int[][] smap = new int[N][N];
		ArrayList<Integer>[][] dmap = new ArrayList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dmap[i][j] = new ArrayList<>();
			}
		}
		
		
		ArrayList<int[]> list = new ArrayList<>();
		int[] di = {-1,-1,0,1,1, 1, 0,-1};
		int[] dj = { 0, 1,1,1,0,-1,-1,-1};
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			int[] ia = new int[5];
			for(int j=0; j<5; j++) {
				if(j>1) ia[j] = Integer.parseInt(s[j]);
				else  ia[j] = Integer.parseInt(s[j])-1;
			}
			list.add(ia);
		}
		
		for(int k=0; k<K; k++) {
			// 파이어볼 이동
			for(int i=0; i<list.size(); i++) {
				int[] curr = list.get(i);
				int ni = curr[0];
				int nj = curr[1];
				for(int j=0; j<curr[3]; j++) {
					ni += di[curr[4]];
					nj += dj[curr[4]];
					if(ni < 0) ni = N-1;
					if(ni >= N) ni = 0;
					if(nj < 0) nj = N-1;
					if(nj >= N) nj = 0;
				}
				list.set(i, new int[] {ni,nj, curr[2], curr[3], curr[4]});
			}
			// 맵초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mmap[i][j] = 0;
					smap[i][j] = 0;
					dmap[i][j] = new ArrayList<>();
				}
			}
			
			// 이동후 맵에 표시
			for(int[] l:list) {
				mmap[l[0]][l[1]] += l[2];
				smap[l[0]][l[1]] += l[3];
				dmap[l[0]][l[1]].add(l[4]);
			}
			
			//for(int[] m:mmap) System.out.println(Arrays.toString(m));
			//for(ArrayList[] d:dmap)System.out.println(Arrays.toString(d));
			// 이동후 나누기
			ArrayList<int[]> nlist = new ArrayList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(dmap[i][j].size() > 1) {
						
						if(mmap[i][j]/5 > 0) {
						
							int bol = 0;
							int fd = dmap[i][j].get(0);
							for(int d:dmap[i][j]) {
								if(fd%2 != d%2) {
									bol = 1;
									break;
								}
							}
							int[] newd = new int[4];
							if(bol==0) {
								newd[0] = 0;
								newd[1] = 2;
								newd[2] = 4;
								newd[3] = 6;
							} else {
								newd[0] = 1;
								newd[1] = 3;
								newd[2] = 5;
								newd[3] = 7;
							}
							for(int d=0; d<4; d++) {
//								int ni = i+di[newd[d]];
//								int nj = j+dj[newd[d]];
//								if(ni < 0) ni = N-1;
//								if(ni >= N) ni = 0;
//								if(nj < 0) nj = N-1;
//								if(nj >= N) nj = 0;
								nlist.add(new int[] {i,j, mmap[i][j]/5, smap[i][j]/dmap[i][j].size(), newd[d]});
							}
							
						}
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0]==i && list.get(l)[1]==j ) {
								list.remove(l);
								l--;
							}
						}
					}
				}
			}
			for(int[] n:nlist) list.add(n);
		}
		
		int result = 0;
		//for(int[] l:list) System.out.println(Arrays.toString(l));
		for(int[] l:list) result += l[2];
		
		System.out.println(result);

	}

}
