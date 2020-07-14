def solution(n, times):
    answer = -1
    
    times.sort()
    l = 0
    r = times[-1] * n
    
    while l <= r :
        
        mid = int((l+r)/2)
        tmp = 0
        for i in times : 
            tmp += int(mid/i)
            
        if tmp >= n :
            if answer == -1 :
                answer = mid
            else : 
                if answer > mid : 
                    answer = mid
            r = mid -1
        else :
            l = mid + 1
    
    
    return answer