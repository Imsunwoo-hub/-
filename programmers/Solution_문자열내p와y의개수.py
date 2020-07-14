def solution(s):
    answer = True
    s = s.lower()
    p_count = 0
    y_count = 0
    
    for i in s :
        if i=='p' :
            p_count += 1
        if i=='y' :
            y_count += 1 
    
    if p_count != y_count :
        answer = False
    return answer