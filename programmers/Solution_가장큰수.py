from functools import cmp_to_key
def solution(numbers):
    answer = ''
    temp = list(str(i) for i in numbers)
    t = list(set(numbers))
    if len(t) == 1 and t[0] == 0 :
        answer = "0"
    else :
        #t = sorted(temp,key=cmp_to_key(lambda a, b:int(a+b)-int(b+a)),reverse=True)
        temp.sort(key=cmp_to_key(lambda x,y: int(x+y)-int(y+x)), reverse=True)
        answer = ''.join(temp)
    return answer