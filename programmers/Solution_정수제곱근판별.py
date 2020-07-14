def solution(n):
    answer = -1
    if n==1 : answer = 4
    else :
        for i in range(2, int(n/2)+2):
            if i**2 == n :
                answer = (i+1)**2
                break  
                
    return answer