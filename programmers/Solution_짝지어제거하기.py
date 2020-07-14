def solution(s):
    answer = 0
    temp = []
    temp.append(s[0])
    for i in range(1, len(s)) : 
        if len(temp) == 0 or temp[-1] != s[i] : 
            temp.append(s[i])
        elif temp[-1] == s[i] :
            del temp[len(temp)-1]
            
    if len(temp) == 0 :
        answer = 1
        
    return answer