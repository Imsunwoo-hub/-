def solution(begin, target, words):
    
    if target not in words :
        answer = 0
    else :
        answer = 0 
        while True :
            temp = []
            c = 0
            for i in words :
                count = 0
                for j in range(0, len(i)) :
                    if i[j] == begin[j] :
                        count += 1
                        if count == len(words[0])-1 :
                            temp.append(i)
                        
            for i in temp :
                if i == target :
                    begin = i 
                    answer += 1
                    c += 1
                    break
            if c == 0 :
                answer += 1
                begin = temp[0]
                words.remove(begin)
                          
            if  begin == target : break
            
    
    return answer