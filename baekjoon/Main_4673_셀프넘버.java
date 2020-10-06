package beakjoon;

public class Main_4673_셀프넘버 {

	public static void main(String[] args) {
		
		int[] ia = new int[100000];
		
		for(int i=1; i<10001; i++) {
			ia[selfNumber(i)]++;
			if(ia[i]==0) System.out.println(i);
		}
	}
	
	
	public static int selfNumber(int i) {
		int ans = i;
		String s = i+"";
		for(int k=0; k<s.length(); k++) {
			ans += s.charAt(k)-'0';
		}
		return ans;
	}
}
