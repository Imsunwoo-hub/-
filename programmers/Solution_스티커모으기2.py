def solution(sticker):
    answer = 0
    if len(sticker) == 1 :
         answer = sticker[0]
    else :
        temp1 = []
        temp1.append(sticker[0])
        temp1.append(sticker[0])
        for i in range(2, len(sticker)-1) :
            temp1.append(max(temp1[i-1], temp1[i-2] + sticker[i] ))
        temp2 = [0]
        temp2.append(sticker[1])
        for i in range(2, len(sticker)) :
            temp2.append(max(temp2[i-1], temp2[i-2] + sticker[i]))
        answer = max(temp1[-1], temp2[-1])
    return answer