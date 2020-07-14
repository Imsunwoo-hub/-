package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_새로운게임2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[][] map = new int[N][N];
		
		for(int i=0; i<N ;i++) {
			String[] t = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(t[j]);
			}
		}
		
		int[] di = {0,0,-1,1};
		int[] dj = {1,-1,0,0};
		int[][][] cmap = new int[N][N][K];
		ArrayList<int[]> mals = new ArrayList<>();
		for(int i=0; i<K; i++) {
			String[] t = br.readLine().split(" ");
			int[] ia = new int[3];
			for(int j=0; j<3; j++) {
				ia[j] = Integer.parseInt(t[j])-1; 
			}
			cmap[ia[0]][ia[1]][0] = i+1;
			mals.add(ia);
		}
		int result = 0;
		
		while(true) {
			if(result > 1000) {
				result = -1;
				break;
			}
			result++;
			int bol = 0;
			
			for(int i=0; i<mals.size(); i++) {
				int[] curr = mals.get(i);
				int ni = curr[0] + di[curr[2]];
				int nj = curr[1] + dj[curr[2]];
				int d = curr[2];
				ArrayList<Integer> tmals = new ArrayList<>();
				
				//for(int[] m:mals)System.out.println(Arrays.toString(m));
				for(int k=0; k<K; k++) {
					if(cmap[curr[0]][curr[1]][k]==i+1) {
						for(int x=k; x<K; x++) {
							if(cmap[curr[0]][curr[1]][x]==0) break;
							tmals.add(cmap[curr[0]][curr[1]][x]);
							cmap[curr[0]][curr[1]][x] = 0;
						}
						break;
					}
				}
				//System.out.println(d);
				if(ni<0 || nj<0 || ni>=N || nj>=N) {
					//int tni = ni;
					//int tnj = nj;
					int td = curr[2];
					if(td==0) {
						ni = curr[0]+di[1];
						nj = curr[1]+dj[1];
						td = 1;
					}
					else if(td==1) {
						ni = curr[0]+di[0];
						nj = curr[1]+dj[0];
						td = 0;
					}
					else if(td==2) {
						ni = curr[0]+di[3];
						nj = curr[1]+dj[3];
						td = 3;
					}
					else if(td==3) {
						ni = curr[0]+di[2];
						nj = curr[1]+dj[2];
						td = 2;
					}
					
					if(map[ni][nj]==0) {
						d = td;
						for(int k=0; k<K; k++) {
							if(cmap[ni][nj][k]==0) {
								int idx = k;
								for(int a : tmals) {
									cmap[ni][nj][idx++] = a;
									if(a==i+1) {
										mals.set(a-1, new int[]{ni,nj, d});
									}
									else {
										mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
									}
								}
								break;
							}
							
						}
					}
					else if(map[ni][nj]==1) {
						d = td;
						for(int k=0; k<K; k++) {
							if(cmap[ni][nj][k]==0) {
								int idx = k;
								for(int a=tmals.size()-1; a>=0; a--) {
									cmap[ni][nj][idx++] = tmals.get(a);
									if(tmals.get(a)==i+1) {
										mals.set(tmals.get(a)-1, new int[]{ni,nj, d});
									}
									else {
										mals.set(tmals.get(a)-1, new int[]{ni,nj,mals.get(tmals.get(a)-1)[2]});
									}
								}
								break;
							}
						}
					}
					else if(map[ni][nj]==2) {
						ni = curr[0];
						nj = curr[1];
						d = td;
							for(int k=0; k<K; k++) {
								if(cmap[ni][nj][k]==0) {
									int idx = k;
									for(int a : tmals) {
										cmap[ni][nj][idx++] = a;
										if(a==i+1) {
											mals.set(a-1, new int[]{ni,nj, d});
										}
										else {
											mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
										}
									}
									break;
								}
							}					
					}
					
				}
				
				else {
					if(map[ni][nj]==0) {
						for(int k=0; k<K; k++) {
							if(cmap[ni][nj][k]==0) {
								int idx = k;
								for(int a : tmals) {
									cmap[ni][nj][idx++] = a;
									if(a==i+1) {
										mals.set(a-1, new int[]{ni,nj, d});
									}
									else {
										mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
									}
								}
								break;
							}
							
						}
					}
					else if(map[ni][nj]==1) {
						for(int k=0; k<K; k++) {
							if(cmap[ni][nj][k]==0) {
								int idx = k;
								for(int a=tmals.size()-1; a>=0; a--) {
									cmap[ni][nj][idx++] = tmals.get(a);
									if(tmals.get(a)==i+1) {
										mals.set(tmals.get(a)-1, new int[]{ni,nj, d});
									}
									else {
										mals.set(tmals.get(a)-1, new int[]{ni,nj,mals.get(tmals.get(a)-1)[2]});
									}
								}
								break;
							}
						}
					}
					
					else if(map[ni][nj] == 2) {
						int tni = ni;
						int tnj = nj;
						int td = curr[2];
						if(td==0) {
							tni = curr[0]+di[1];
							tnj = curr[1]+dj[1];
							td = 1;
						}
						else if(td==1) {
							tni = curr[0]+di[0];
							tnj = curr[1]+dj[0];
							td = 0;
						}
						else if(td==2) {
							tni = curr[0]+di[3];
							tnj = curr[1]+dj[3];
							td = 3;
						}
						else if(td==3) {
							tni = curr[0]+di[2];
							tnj = curr[1]+dj[2];
							td = 2;
						}
						
						if(tni<0 || tnj<0 || tni>=N || tnj>=N) {
							ni = curr[0];
							nj = curr[1];
							d = td;
								for(int k=0; k<K; k++) {
									if(cmap[ni][nj][k]==0) {
										int idx = k;
										for(int a : tmals) {
											cmap[ni][nj][idx++] = a;
											if(a==i+1) {
												mals.set(a-1, new int[]{ni,nj, d});
											}
											else {
												mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
											}
										}
										break;
									}
								}
						}
						
						else {
							if(map[tni][tnj]==0) {
							ni = tni;
							nj = tnj;
							d = td;
							for(int k=0; k<K; k++) {
								if(cmap[ni][nj][k]==0) {
									int idx = k;
									for(int a : tmals) {
										cmap[ni][nj][idx++] = a;
										if(a==i+1) {
											mals.set(a-1, new int[]{ni,nj, d});
										}
										else {
											mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
										}
									}
									break;
								}
								
							}
						}
						else if(map[tni][tnj]==1) {
							ni = tni;
							nj = tnj;
							d = td;
							for(int k=0; k<K; k++) {
								if(cmap[ni][nj][k]==0) {
									int idx = k;
									for(int a=tmals.size()-1; a>=0; a--) {
										cmap[ni][nj][idx++] = tmals.get(a);
										if(tmals.get(a)==i+1) {
											mals.set(tmals.get(a)-1, new int[]{ni,nj, d});
										}
										else {
											mals.set(tmals.get(a)-1, new int[]{ni,nj,mals.get(tmals.get(a)-1)[2]});
										}
									}
									break;
								}
							}
						}
						else if( map[tni][tnj]==2) {
							ni = curr[0];
							nj = curr[1];
							d = td;
								for(int k=0; k<K; k++) {
									if(cmap[ni][nj][k]==0) {
										int idx = k;
										for(int a : tmals) {
											cmap[ni][nj][idx++] = a;
											if(a==i+1) {
												mals.set(a-1, new int[]{ni,nj, d});
											}
											else {
												mals.set(a-1, new int[]{ni,nj,mals.get(a-1)[2]});
											}
										}
										break;
									}
								}
						}
					}
				}
			}
				
				
				
				int count = 0;
				for(int k=0; k<K; k++) {
					if(cmap[ni][nj][k]>0) count++;
				}
				if(count>=4) {
					bol = 1;
					break;
				}
//				for(int[][] a:cmap) {
//					System.out.println(); for(int[] b:a) System.out.print(Arrays.toString(b)); 
//				}
//				System.out.println();
				//System.out.println(count);
			}
		
			
			if(bol==1) {
				break;
			}
			
			
		}
		//for(int[] m:map)System.out.println(Arrays.toString(m));
		System.out.println(result);

	}

}
