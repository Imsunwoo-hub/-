def solution(n, m):
    answer = []
    max = 1
    count = 0
    
    while True :
        c = 0 
        for i in range(2, m*n+1):
            if m%i==0 and n%i==0 :
                max *= i
                m = int(m/i)
                n = int(n/i)
                count += 1 
                c += 1
                break
                
        if c == 0 : break         
        if(m==1 or n ==1): break
            
    if count == 0 :
        answer.append(1)
        answer.append(n*m)
    else : 
        answer.append(max)
        answer.append(max*n*m)
    return answer