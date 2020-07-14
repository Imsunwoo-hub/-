def solution(n, works):
    answer = 0
    if n > sum(works) : answer = 0
    else :
        while n > 0 :
            works.sort(reverse = True)
            count = works.count(works[0]) 
            if works[0] == 0 : break 
            for i in range(0, count) :
                works[i] -= 1 
                n -= 1
                if n == 0 : break
        for i in works:
            answer += i**2
    return answer