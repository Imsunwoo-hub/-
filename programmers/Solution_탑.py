def solution(heights):
    answer = []
    count = len(heights)
    while count > 1 :
        n = 0
        k = heights[count-1]
        for i in range(count-2, -1, -1) :
            if heights[i] > k :
                n = i + 1
                break
        answer.append(n)
        count -= 1
    
    answer.append(0)
    return answer[::-1]