def solution(n, arr1, arr2):
    
    answer = []
    temp = []
    
    for i in range(0, n):
        temp.append(bin(arr1[i] | arr2[i]))
    
    for i in temp:
        print(i , len(i))
        if  len(i) < n+2 :
            str = " "*((n+2)-len(i))
        else:
            str = ""
        for j in range(2, len(i)): 
            if i[j] == '1' :
                str += "#"
            elif i[j] == '0' :
                str += " "
        answer.append(str)
    
    return answer