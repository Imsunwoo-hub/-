package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_선긋기 {
	
	static class Points{
		int x;
		int y;
		Points(int x, int y){
			this.x = x;
			this.y=  y;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Points[] points = new Points[N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			points[i] = new Points(Integer.parseInt(s[0]),Integer.parseInt(s[1]) );
					
		}
		
		Arrays.sort(points, new Comparator<Points>() {

			@Override
			public int compare(Points o1, Points o2) {
				int r= Integer.compare(o1.x, o2.x);
				if(r==0) r = Integer.compare(o1.y, o2.y);
				return r;
			}
		});
		
		int result = 0;
		
		int start = points[0].x;
		int end = points[0].y;
		
		for(int i=1; i<N; i++) {
			Points p = points[i];
			if(p.x > end) {
				result += end-start;
				start = p.x;
				end = p.y;
			}
			
			else {
				if(end < p.y) {
					end = p.y;
				}
			}
			
		}
		
		result += end-start;
		
		System.out.println(result);

	}

}
