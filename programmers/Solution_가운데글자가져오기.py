def solution(s):
    answer = ''
    temp = int(len(s)/2)
    if len(s)%2==0 :
         answer = s[temp-1]+s[temp]
    else:
         answer = s[temp]
    return answer