def solution(n):
    answer = 0
    temp = [1,0,3]
    for i in range(3, n+1) :
        result = (3 * temp[i-2]) % 1000000007
        for j in range(3, i+1) :
            if j%2 == 0 : 
                result += (2 * temp[i-j]) % 1000000007
        temp.append(result)
    answer = temp[n] % 1000000007
    return answer