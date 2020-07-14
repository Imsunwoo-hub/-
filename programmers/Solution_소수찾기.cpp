#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    vector<int> v;
    
    for(int i=2; i<=n; i++){
        v.push_back(i);
    }
    for(int i=2; i<=n; i++){
        if(v[i]==0){
            continue;
        }
        answer++;
        for(int j=2; j<=n; j+=i){
            v[i] = 0;
            if(i%j==0){
                answer--;
                break;
            }
        }
        
    }
    
    return answer;
}