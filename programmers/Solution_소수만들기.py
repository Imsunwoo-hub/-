from itertools import combinations
import math
def solution(nums):
    answer = 0
    temp = list(combinations(nums,3))
    
    for i in temp :
        hap = sum(i)
        count = 0 
        for j in range(2, int(math.sqrt(hap)+1)):
            if hap%j==0 :
                count = 1
                break
        if count == 0 : 
            answer += 1
           
    return answer