def solution(arr):
    answer = []
    if len(arr)==1 : answer.append(-1)
    else :
        a = []
        for i in arr : a.append(i)
        a.sort()
        n = a[0] 
        for i in arr :
            if n != i :
                answer.append(i)
    return answer