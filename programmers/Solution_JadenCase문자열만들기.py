def solution(s):
    answer = ''
    count = 0
    for i in s :
        if count ==0 and i.isalpha() :
            answer += i.upper()
            count += 1
        elif i == " " :
            answer += i 
            count = 0
        else :
            answer += i.lower()
            count += 1
        
    return answer