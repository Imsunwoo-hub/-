def solution(s):
    answer = True
    r_count = 0
    l_count = 0
    for i in s:
        if i == '(':
            l_count += 1 
            if l_count > int(len(s)+1) :
                answer = False
                break
        elif i == ')' :
            r_count +=1 
            if l_count > 0 : 
                r_count -= 1
                l_count -= 1
            if r_count > l_count : 
                answer = False
                break
    if l_count > r_count : answer = False
    return answer