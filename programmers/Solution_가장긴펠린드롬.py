def solution(s):
    answer = 0
    start = 0
    t = [1]
    while start < len(s)-1 :
        temp = s[start]
        start += 1
        for i in range(start, len(s)) :
            temp += s[i]
            if temp == temp[::-1] :
                t.append(len(temp))
    answer = max(t)
    return answer