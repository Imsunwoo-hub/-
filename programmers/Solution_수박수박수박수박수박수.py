def solution(n):
    answer = ''
    t = ["수", '박']
    
    for i in range(0, n) :
        n = i%2
        answer += t[n]
    
    return answer