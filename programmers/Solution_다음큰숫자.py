def solution(n):
    
    answer = 0
    count = 0
    a = bin(n)
    for i in str(a):
        if i == '1' : count += 1 
    
    while True :
        c = 0
        n += 1
        for i in str(bin(n)) :
            if i == '1' : c +=1
        if c == count : 
            answer = n
            break
    return answer