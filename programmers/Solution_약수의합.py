def solution(n):
    if n==0 : answer = 0
    elif n ==1 : answer = 1
    else :
        answer = 1+n
        for i in range(2, int(n/2)+1):
            if n%i==0 :
                answer += i


    return answer