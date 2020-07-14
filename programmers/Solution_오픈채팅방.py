def solution(record):
    answer = []
    u = []
    dic = {}
    id = ""
    name = ""
    
    for i in record :
        u = i.split(" ")
        if(u[0]=="Enter"):
            id = u[1]
            name = u[2]
            dic[id] = name
        
        if(u[0]=="Change"):
            id = u[1]
            name = u[2]
            dic[id] = name
            
    for i in record :
        u = i.split(" ")
        if (u[0]=="Enter"):
            answer.append(dic[u[1]] + "님이 들어왔습니다.")
        if (u[0]=="Leave"):
            answer.append(dic[u[1]] + "님이 나갔습니다.")
    
    return answer