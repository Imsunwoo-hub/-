def solution(genres, plays):
    answer = []
    dic = {}
    temp = list(set(genres))
    sum = []
    for i in range(0, len(temp)) :
        n = 0
        for j in range(0, len(genres)) :
            if i ==0 :
                a = []
                a.append(genres[j])
                a.append(plays[j])
                sum.append(a)
            if temp[i] == genres [j] :
                n += plays[j] 
        dic[temp[i]] = n
    
    dic_list = sorted(dic, key=lambda k : dic[k], reverse=True)
    sum.sort(reverse = True)
    g_idx = []
    p_idx = []
    c = 0 
    for i in dic_list :
        count = 0
        c += genres.count(i) 
        if genres.count(i) == 1:
            for j in range(0, len(sum)):
                if i == sum[j][0] :
                    g_idx.append(sum[j][0])
                    p_idx.append(sum[j][1])
                    break
        else: 
            for j in range(0, len(sum)) :
                if i == sum[j][0] :
                    if plays.count(sum[j][1]) > 1 :
                        g_idx.append(sum[j][0])
                        p_idx.append(sum[j][1])
                        count = 2
                    else :
                        g_idx.append(sum[j][0])
                        p_idx.append(sum[j][1])
                        count += 1
                    if count == 2 : break
    
    
    for i in range(0, len(p_idx)) :
        if c == 0 :
            break
        for j in range(0, len(plays)):
            if(p_idx[i]==plays[j] and g_idx[i]== genres[j]) :
                answer.append(j)
                plays[j] = 0
                c -=1
                if c == 0 :
                    break
            
    return answer