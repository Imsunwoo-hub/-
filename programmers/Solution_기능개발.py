def solution(progresses, speeds):
    answer = []
    while True :
        for i in range(0, len(progresses)) :
            progresses[i] =  progresses[i] + speeds[i]
            
        for i in range(0, len(progresses)):
            count = 0
            if progresses[i] >= 100 : 
                for j in range(0, len(progresses)) :
                    if progresses[j] < 100 : break
                    else : count +=1      
            if count != 0 and count != sum(answer) : answer.append( count - sum(answer))
                
        if sum(answer) == len(progresses) : break
    return answer