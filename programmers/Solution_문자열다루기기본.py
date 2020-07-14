def solution(s):
    answer = True
    if len(s) != 4 and len(s) != 6 :
        answer = False
    for i in s :
        if ord(i) < 48 or ord(i) > 57  :
            print(ord(i))
            answer = False
            break
    
    return answer