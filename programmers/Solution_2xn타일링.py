def solution(n):
    answer = [0,1,2]
    for i in range(3, n+1) :
        answer.append((answer[i-2]% 1000000007) + (answer[i-1]% 1000000007))
    answer = answer[n] % 1000000007 
    return answer