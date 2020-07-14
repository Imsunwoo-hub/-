def solution(str1, str2):
    answer = 0
    str1 = str1.upper()
    str2 = str2.upper()
    str1_list = []  
    str2_list = []
    union = 0
    intersection = 0
    for i in range(0,len(str1)-1) :
        if (str1[i:i+2].isalpha()) :
            str1_list.append(str1[i:i+2])
    
    for i in range(0,len(str2)-1) :
        if str2[i:i+2].isalpha() :
            str2_list.append(str2[i:i+2])
       
    for i in set(str1_list+str2_list):
        intersection += min(str1_list.count(i), str2_list.count(i))
        union += max(str1_list.count(i), str2_list.count(i))

    if(union==0):
        answer = 1*65536
    else :
        answer = int((intersection/union)*65536)
            
    return answer