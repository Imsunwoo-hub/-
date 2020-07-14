def solution(strings, n):
    answer = []
    temp = []
    
    for i in strings :
        temp.append(i[n])
    temp = list(set(temp))
    temp.sort()
    
    for i in temp :
        temp1 = []
        for j in strings :
            if i == j[n] :
                temp1.append(j)
        temp1.sort()
        answer += temp1
    
    return answer