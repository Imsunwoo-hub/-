def solution(n):
    answer = 0
    a = []
    for i in str(n) :
        a.append(i)
    a.sort(reverse = True)
    b = ''
    for i in a :
        b += i
    answer = int(b)
    return answer