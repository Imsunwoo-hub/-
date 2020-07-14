def solution(baseball):
    answer = 0
    temp = []
    baseball_temp  = []
    for i in baseball :
        baseball_temp.append(str(i[0]))
    
    for i in range(123, 988) :
        s = str(i)
        s = list(j for j in s)
        count = 0
        if '0' in s :
            continue
        for j in s :
            if s.count(j) >= 2 :
                count = 1
                break
        if count == 0 :
            temp.append(str(i))
    
    for i in temp :
        result = []
        c = 0
        for j in range(0,len(baseball_temp)) :
            strike = 0
            ball = 0
            re = []
            t = list(a for a in baseball_temp[j])
            for k in range(0, len(i)) :
                if i[k] == t[k] : 
                    strike += 1
                elif i[k] != t[k] and i[k] in t : 
                    ball += 1
            re.append(strike)
            re.append(ball)
            result.append(re)
        for j in range(0, len(result)):
            if result[j][0] == baseball[j][1] and result[j][1] == baseball[j][2] : 
                c = c + 1
        if c == len(baseball) :
            answer += 1
    return answer