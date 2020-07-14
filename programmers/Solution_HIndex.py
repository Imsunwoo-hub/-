def solution(citations):
    answer = 0
    citations.sort(reverse =True)
    
    for i in range(citations[0], 0, -1) :
        up = 0
        for j in citations :
            if j >= i :
                up += 1
            else : 
                break 
        if up >= i:
            answer = i
            break
    return answer