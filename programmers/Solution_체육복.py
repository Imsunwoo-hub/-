def solution(n, lost, reserve): 
    answer = 0
    temp = []
    for i in range(len(lost)):
        t = lost[i]
        if t in reserve:
            answer += 1
            temp.append(t)
        elif t-1 in reserve and t-1 not in temp and t-1 not in lost:
            answer += 1
            temp.append(t-1)
        elif t+1 in reserve and t+1 not in temp and t+1 not in lost:
            answer += 1
            temp.append(t+1)
    answer += (n - len(lost))

    return answer