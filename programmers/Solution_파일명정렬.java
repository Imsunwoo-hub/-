package programmers;

import java.util.*;


class Solution_파일명정렬 {
  public String[] solution(String[] files) {
      String[] answer = new String[files.length];
      for(int i=0; i<files.length; i++){
          answer[i] = files[i];
      }
     Arrays.sort(answer, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
                    
                    String head1 = "";
                    String num1 = "";
                    int bol1 = 0;
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i)>= '0' && o1.charAt(i) <= '9') {
                            bol1 = 1;
                            num1 += o1.charAt(i);
                        }
                        if(bol1==0) head1 += o1.charAt(i);
                        if(o1.charAt(i)=='.') break;
                    }
                    
                    String head2 = "";
                    String num2 = "";
                    int bol2 = 0;
                    for(int i=0; i<o2.length(); i++){
                        if(o2.charAt(i)>= '0' && o2.charAt(i) <= '9') {
                            bol2 = 1;
                            num2 += o2.charAt(i);
                        }
                        if(bol2==0) head2 += o2.charAt(i);
                        if(o2.charAt(i)=='.') break;
                    }
					
					head1 = head1.toLowerCase();
					head2 = head2.toLowerCase();
					int r = head1.compareTo(head2);
					if(r==0) r = Integer.compare(Integer.parseInt(num1), Integer.parseInt(num2));
					return r;
				}
			});
      
      return answer;
  }
}