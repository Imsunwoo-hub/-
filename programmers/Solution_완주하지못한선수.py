def solution(participant, completion):
    answer = ''
    
    if(len(set(participant)-set(completion))==0) :
        participant.sort()
        completion.sort()
        for i,j in zip(participant,completion):     
            if i != j:
                answer = i
                break
    else :
        answer = list(set(participant)-set(completion))[0]
    

   
    return answer