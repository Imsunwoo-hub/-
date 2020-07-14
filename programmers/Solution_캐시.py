def solution(cacheSize, cities):
    
    answer = 0
    
    if(cacheSize==0) :
        answer = 5*len(cities) 
        
    elif (cacheSize == 1) :
        
        temp = cities[0].lower()
        answer += 5
        for i in range(1, len(cities)) :
            if temp == cities[i].lower() :
                answer += 1
            else :
                temp = cities[i].lower()
                answer += 5 
    else :
        temp = []
        for i in cities :
            i = i.lower()      
            if i in temp :
                temp.remove(i)
                temp.append(i)
                answer +=1
            else :
                if len(temp) < cacheSize :
                    temp.append(i)
                    answer +=5  
                else :
                    temp.append(i)
                    temp.remove(temp[0])
                    answer +=5  
                
    return answer