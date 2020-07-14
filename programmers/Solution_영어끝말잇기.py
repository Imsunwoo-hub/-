def solution(n, words):
    answer = []
    temp = []
    temp.append(words[0])
    print(words[0][-1])
    print(words[1][0])
    for j in range(1, len(words)) :
        if words[j-1][-1] != words[j][0] :
            answer.append(j%n+1)
            if (j+1)%n==0 : answer.append(int((j+1)/n))
            elif (j+1)%n!=0 : answer.append(int((j+1)/n)+1)
            break
        elif words[j] in temp : 
            answer.append(j%n+1)
            if (j+1)%n==0 : answer.append(int((j+1)/n))
            elif (j+1)%n!=0 : answer.append(int((j+1)/n)+1)
            break
        #elif len(word[j])    
        temp.append(words[j])    
    if len(answer)==0 :
        answer = [0,0]
    return answer