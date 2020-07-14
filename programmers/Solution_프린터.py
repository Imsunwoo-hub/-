def solution(priorities, location):
    answer = 0
    temp = []
    for i in range(0, len(priorities)) :
        t = []
        t.append(priorities[i])
        t.append(i)
        temp.append(t)
    priorities.sort(reverse = True)   
    print(priorities[0])
    print(temp[0])
    a = []
    l = -1
    while True :
        
        if priorities[0] > temp[0][0] :
            a = temp[0]
            print(a)
            del temp[0]
            temp.append(a)
        if priorities[0] == temp[0][0] :
                answer += 1
                l = temp[0][1]
                del priorities[0]
                del temp[0]
        if l == location :
            break
    return answer