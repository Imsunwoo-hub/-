def solution(board):
    answer = 0
    temp =[]
    for i in range(0, len(board)+1) :
        t = []
        for i in range(0, len(board[0])+1) :
            t.append(0)
        temp.append(t)
    for i in range(1, len(board)+1):
        for j in range(1,len(board[0])+1) :
            if board[i-1][j-1] != 0 :
                temp[i][j] = min(temp[i][j-1], temp[i-1][j], temp[i-1][j-1]) + 1
                answer = max(answer, temp[i][j])
    answer = answer * answer
    return answer