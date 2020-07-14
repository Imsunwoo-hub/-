def solution(phone_number):
    answer = ''
    a = len(phone_number)
    
    for i in range(0, len(phone_number)) :
        if i < len(phone_number)-4 :
            answer += '*'
        else : answer += phone_number[i]
    
    
    return answer