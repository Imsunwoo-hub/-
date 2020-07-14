def solution(operations):
    answer = []
    temp = []
    for i in operations :
        s = ""
        if i[0] == 'I':
            if i[2] != '-':
                for j in range(2, len(i)) :
                    s += i[j]
                temp.append(int(s))
            if i[2] == '-' :
                s += '-'
                for j in range(3, len(i)) :
                    s += i[j]
                temp.append(int(s))
                
        if i[0] == 'D' :
            if i[2] != '-' and len(temp) != 0 :
                temp.remove(max(temp))
            if i[2] == '-' and len(temp) != 0 :
                temp.remove(min(temp))
    
    
    if len(temp)==0:
        answer.append(0)
        answer.append(0)
    else :
        answer.append(max(temp))
        answer.append(min(temp))
    return answer