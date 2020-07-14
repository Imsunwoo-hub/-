def solution(s):
    answer = 0
    temp = ''
    n = 0
    for i in s :
        if i == "-" :
            n += 1
        elif i == "+" :
            continue
        else :
            temp += i
            
    if n==1:
        answer = -(int(temp))
    else:
        answer = int(temp)
    return answer