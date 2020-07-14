package programmers;

class Solution_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        for(int i=0; i<stations.length; i++){
            if(i==0){
                int s = stations[i];
                while(true){
                    if(s-w-1<1) break;
                    s -= w*2+1;
                    answer++;
                    //System.out.println(s);
                    if(s<1){
                        break;
                    }
                }
                s = stations[i];
                if(i+1 < stations.length){
                    int next = stations[i+1];
                    while(true){
                        if(s+w+1>=next-w) break;
                        s += w*2+1;
                        answer++;
                        //System.out.println(s);
                        if(s>=next-w) break;
                    }
                }
                else{
                    int end = n;
                    while(true){
                        if(s+w+1>end) break;
                        s += w*2+1;
                        answer++;
                        //System.out.println(s);
                        if(s>end) break;
                    }
                }
            }
            else{
                int s = stations[i];
                if(i+1 < stations.length){
                    int next = stations[i+1];
                    while(true){
                        if(s+w+1>=next-w) break;
                        s += w*2+1;
                        answer++;
                        //System.out.println(s);
                        if(s>=next-w) break;
                    }
                }
                else{
                    int end = n;
                    while(true){
                        if(s+w+1>end) break;
                        s += w*2+1;
                        answer++;
                        //System.out.println(s);
                        if(s>end) break;
                    }
                }
            }
            
        }

        return answer;
    }
}
