def solution(s):
    answer = ''
    temp = s.split(" ")
    max = int(temp[0])
    min = int(temp[0])
    
    for i in temp:
        if i != " " :
            if int(i) < min :
                min = int(i)
            if int(i) > max :
                max = int(i)
    
    
    answer += str(min)
    answer += " "
    answer += str(max)
    
    
    
    return answer