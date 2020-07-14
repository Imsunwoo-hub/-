def solution(N, stages):
    dic = {}
    answer = []
    start = 0
    stages.sort()
    for i in range(1, N+1) :
        count = 0
        for j in range(start, len(stages)):
            if(i==stages[j]):
                count += 1
            elif(i<stages[j]):
                start = j
                break      
        dic[i] = count / (count+(len(stages)-j))
    answer = sorted(dic, key=lambda k : dic[k], reverse=True)
    return answer