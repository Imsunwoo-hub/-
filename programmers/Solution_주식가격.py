def solution(prices):
    
    answer = []
    
    for i in range(0,len(prices)) :
        temp = prices[i]
        count = 0
        for j in range(i+1, len(prices)) :
            if temp <= prices[j] : count +=1 
            else : 
                count +=1 
                break
        answer.append(count)
    
    return answer