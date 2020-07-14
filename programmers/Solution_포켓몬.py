def solution(nums):
    answer = 0
    n = len(nums)/2
    temp = list(set(nums))
    k = len(temp)
    if k >= n : answer = n
    else : answer = k
    
    return answer