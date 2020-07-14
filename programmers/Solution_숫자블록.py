import math
def solution(begin, end):
    answer = []
    for i in range(begin, end+1) :
        count = 0
        if i==1 : answer.append(0)
        elif i%2==0 : answer.append(int(i/2))
        else :
            for j in range(3, int(math.sqrt(i)), 2) :
                if i%j == 0 :
                    answer.append(int(i/j))
                    count = 1
                    break  
            if count == 0 : answer.append(1)
  
    return answer