def solution(s):
    answer = ''
    big = []
    small =[]
    for i in s :
        if i.isupper() :
            big += i
        if i.islower() :
            small += i
    big.sort()
    small.sort()
    
    for i in big :
        answer += i
    for i in small :
        answer += i
    
    return answer[::-1]