def solution(clothes):
    answer = 0
    temp = []
    for i in range(0, len(clothes)):
            temp.append(clothes[i][1])
    temp1 = list(set(temp))
        
    a = 1    
    for i in temp1:
        a *= temp.count(i) +1

    answer = a -1
    return answer