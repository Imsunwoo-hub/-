package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_방금그곡 {
	
	public static String solution(String m,  String[] musicinfos) {
		String answer = "(None)";
		
		Arrays.sort(musicinfos, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				int a1 = time(arg0);
				int a2 = time(arg1);
				return -Integer.compare(a1, a2);
			}
		});
		int[] mcount = new int[14];
		int mp = 0;
		for(int i=0; i<m.length(); i++) {
			if(i!=m.length()-1) {
				if(m.charAt(i+1)=='#') {
					mcount[(m.charAt(i)-'A')+7]++;
					i++;
				}
				else {
					mcount[m.charAt(i)-'A']++;
				}
			}
			else mcount[m.charAt(i)-'A']++;
			mp++;
		}
		
		
		
		int[] gasacount = new int[14];
		
		for(int i=0; i<musicinfos.length; i++) {
			int time = time(musicinfos[i]);
			String[] s = musicinfos[i].split(",");
			int len = 0;
			for(int j=0; j<s[3].length(); j++) {
				if(j==s[3].length()-1) {
					len++;
				}else {
					if(s[3].charAt(j+1)=='#') {
						j++;
					}
					len++;
				}
			}
			String[] gasa = new String[len];
			int idx = 0;
			for(int j=0; j<s[3].length(); j++) {
				
				if(j==s[3].length()-1) {
					gasa[idx++] = s[3].charAt(j)+""; 
				}else {
					if(s[3].charAt(j+1)=='#') {
						gasa[idx++] = s[3].charAt(j)+""+s[3].charAt(j+1)+""; 
						j++;
					}
					else {
						gasa[idx++] = s[3].charAt(j)+""; 
					}
				}
			}
			
			System.out.println(Arrays.toString(gasa));
			
			
			for(int j=0; j<14; j++) {
				gasacount[j] = 0;
			}
			
			for(int j=0; j<time; j++) {
				if(gasa[j%len].length()==1) {
					gasacount[gasa[j%len].charAt(0) - 'A']++;
				}
				else {
					gasacount[gasa[j%len].charAt(0) - 'A' + 7]++;
				}
				
				System.out.println(j);
				System.out.println(Arrays.toString(mcount));
				System.out.println(Arrays.toString(gasacount));
				System.out.println();
				
				if(j >= mp-1) {
					int bol = 0;
                    
					for(int k=0; k<14; k++) {
						if(mcount[k] != gasacount[k]) {
							bol = 1;
							break;
						}
					}
					
					if(bol==0) {
						answer = s[2];
						System.out.println(j);
						return answer;
					}
					
					if(gasa[(j-(mp-1))%len].length()==1) {
						gasacount[gasa[(j-(mp-1))%len].charAt(0) - 'A']--;
					}
					else {
						gasacount[gasa[(j-(mp-1))%len].charAt(0) - 'A' + 7]--;
					}
				}
			}
		}

		return answer;
	}
	
	public static int time(String arg) {
		int time = 0;
		
		String[] s1 = arg.split(",");
		
		int[][] t1 = new int[2][2];
		for(int i=0; i<2; i++) {
			String[] t = s1[i].split(":");
			t1[i][0] = Integer.parseInt(t[0]); 
			t1[i][1] = Integer.parseInt(t[1]); 
		}
		time = (t1[1][0]-t1[0][0])*60+t1[1][1] - t1[0][1];
		
		return time;
	}


	public static void main(String[] args) {
		
	}

}
